package net.jaiz.jaizmobs.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.StarFishLeaderEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

@Environment(value = EnvType.CLIENT)
public class StarFishLeader<T extends StarFishLeaderEntity> extends SinglePartEntityModel<T> {
	private final ModelPart star_fish_leader;


	public StarFishLeader(ModelPart root) {
		this.star_fish_leader = root.getChild("star_fish_leader");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData star_fish_leader = modelPartData.addChild("star_fish_leader", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 18.5F, -1.5F));

		ModelPartData body = star_fish_leader.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.5F, -3.5F, 2.0F, 5.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(0.0F, -5.5F, -3.5F, 0.0F, 3.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 5).cuboid(0.0F, 2.5F, -3.5F, 0.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 13).cuboid(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 3.5F));

		ModelPartData left_fin = body.addChild("left_fin", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 1.0F, -1.5F));

		ModelPartData cube_r1 = left_fin.addChild("cube_r1", ModelPartBuilder.create().uv(11, 0).cuboid(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.0F));

		ModelPartData right_fin = body.addChild("right_fin", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 1.0F, -1.5F));

		ModelPartData cube_r2 = right_fin.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.0F));
		return TexturedModelData.of(modelData, 24, 24);
	}

	@Override
	public void setAngles(StarFishLeaderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(ModAnimations.STAR_FISH_LEADER_IDLE, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.STAR_FISH_LEADER_SWIM, ageInTicks, 1f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		star_fish_leader.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return star_fish_leader;
	}
}