package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.SnailEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class Snail<T extends SnailEntity> extends SinglePartEntityModel<T> {
	private final ModelPart snail;

	public Snail(ModelPart root) {
		this.snail = root.getChild("snail");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData snail = modelPartData.addChild("snail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData shell = snail.addChild("shell", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, -2.5F, -1.5F));

		ModelPartData shell_r1 = shell.addChild("shell_r1", ModelPartBuilder.create().uv(0, 11).cuboid(-1.5F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.2577F, 2.9014F, -0.3491F, 0.0F, 0.0F));

		ModelPartData eye_l = snail.addChild("eye_l", ModelPartBuilder.create(), ModelTransform.pivot(0.9441F, -1.9744F, -3.75F));

		ModelPartData eye_l_r1 = eye_l.addChild("eye_l_r1", ModelPartBuilder.create().uv(0, 2).cuboid(-0.5F, -1.75F, 0.25F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0559F, -0.0256F, -0.25F, 0.0F, 0.0F, 0.2618F));

		ModelPartData eye_r = snail.addChild("eye_r", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, -3.75F));

		ModelPartData eye_r_r1 = eye_r.addChild("eye_r_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.75F, 0.25F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.2618F));

		ModelPartData body = snail.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -4.5F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -1.0F, 0.5F));
		return TexturedModelData.of(modelData, 26, 26);
	}

	@Override
	public void setAngles(SnailEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(ModAnimations.SNAIL_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.SNAIL_IDLE, ageInTicks, 0.2f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		snail.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return snail;
	}

}