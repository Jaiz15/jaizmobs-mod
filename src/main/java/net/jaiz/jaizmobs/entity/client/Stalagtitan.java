package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.StalagtitanEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class Stalagtitan<T extends StalagtitanEntity> extends SinglePartEntityModel<T> {
	private final ModelPart stalagtitan;
	private final ModelPart head;

	public Stalagtitan(ModelPart root) {
		this.stalagtitan = root.getChild("stalagtitan");
		this.head = stalagtitan.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData stalagtitan = modelPartData.addChild("stalagtitan", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = stalagtitan.addChild("body", ModelPartBuilder.create().uv(0, 18).cuboid(-4.0F, -15.0F, -2.0F, 8.0F, 16.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -28.0F, -0.5F));

		ModelPartData arm_r = body.addChild("arm_r", ModelPartBuilder.create().uv(24, 18).cuboid(-3.0F, -2.0F, -2.0F, 3.0F, 27.0F, 3.0F, new Dilation(0.0F))
		.uv(32, 53).cuboid(-7.0F, 1.0F, 0.0F, 4.0F, 6.0F, 0.0F, new Dilation(0.0F))
		.uv(24, 48).cuboid(-7.0F, 13.0F, 0.0F, 4.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -12.0F, 0.5F));

		ModelPartData arm_l = body.addChild("arm_l", ModelPartBuilder.create().uv(36, 15).cuboid(0.0F, -2.0F, -2.0F, 3.0F, 27.0F, 3.0F, new Dilation(0.0F))
		.uv(29, 0).cuboid(3.0F, 15.0F, 0.0F, 4.0F, 6.0F, 0.0F, new Dilation(0.0F))
		.uv(38, 0).cuboid(0.0F, -2.25F, -3.0F, 4.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -12.0F, 0.5F));

		ModelPartData shoulder_spine_r1 = arm_l.addChild("shoulder_spine_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -4.25F, 1.0F, 4.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.8727F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -9.0F, -5.0F, 10.0F, 9.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -15.0F, 0.5F));

		ModelPartData frill_top_r = head.addChild("frill_top_r", ModelPartBuilder.create().uv(36, 45).cuboid(-8.0F, -5.0F, 0.0F, 10.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -9.0F, 0.0F));

		ModelPartData frill_top = head.addChild("frill_top", ModelPartBuilder.create().uv(48, 36).cuboid(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.0F, -1.0F));

		ModelPartData frill_l = head.addChild("frill_l", ModelPartBuilder.create().uv(48, 27).cuboid(0.0F, -4.5F, 0.0F, 7.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -4.5F, -1.0F));

		ModelPartData frill_r = head.addChild("frill_r", ModelPartBuilder.create().uv(48, 18).cuboid(-7.0F, -4.5F, 0.0F, 7.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -4.5F, -1.0F));

		ModelPartData frill_top_l = head.addChild("frill_top_l", ModelPartBuilder.create().uv(45, 10).cuboid(-2.0F, -5.0F, 0.0F, 10.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -9.0F, 0.0F));

		ModelPartData leg_l = stalagtitan.addChild("leg_l", ModelPartBuilder.create().uv(12, 38).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 27.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, -27.0F, -0.5F));

		ModelPartData leg_r = stalagtitan.addChild("leg_r", ModelPartBuilder.create().uv(0, 38).cuboid(-1.5F, 0.0F, -2.0F, 3.0F, 27.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, -27.0F, 0.0F));
		return TexturedModelData.of(modelData, 68, 68);
	}
	@Override
	public void setAngles(StalagtitanEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.STALAGTITAN_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.STALAGTITAN_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.STALAGTITAN_ATTACK, ageInTicks, 2f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -30.0f, 30.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		stalagtitan.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return stalagtitan;
	}
}