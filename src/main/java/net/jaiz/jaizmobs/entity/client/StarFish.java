package net.jaiz.jaizmobs.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.StarFishEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

@Environment(value = EnvType.CLIENT)
public class StarFish<T extends StarFishEntity> extends SinglePartEntityModel<T> {
	private final ModelPart star_fish;


	public StarFish(ModelPart root) {
		this.star_fish = root.getChild("star_fish");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData star_fish = modelPartData.addChild("star_fish", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 23.0F, 0.0F));

		ModelPartData body = star_fish.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData fin_l = body.addChild("fin_l", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.0F, -1.0F));

		ModelPartData fin_l_r1 = fin_l.addChild("fin_l_r1", ModelPartBuilder.create().uv(8, 0).cuboid(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

		ModelPartData fin_r = body.addChild("fin_r", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 0.0F, -1.0F));

		ModelPartData fin_r_r1 = fin_r.addChild("fin_r_r1", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(8, 3).cuboid(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 2.0F));

		ModelPartData anal_fin = body.addChild("anal_fin", ModelPartBuilder.create().uv(0, 2).cuboid(0.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 0.0F));

		ModelPartData dorsal_fin = body.addChild("dorsal_fin", ModelPartBuilder.create().uv(0, 5).cuboid(0.0F, -3.0F, -2.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));
		return TexturedModelData.of(modelData, 16, 16);
	}


	@Override
	public void setAngles(StarFishEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(ModAnimations.STARFISH_IDLE, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.STARFISH_SWIM, ageInTicks, 1f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		star_fish.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return star_fish;
	}


}