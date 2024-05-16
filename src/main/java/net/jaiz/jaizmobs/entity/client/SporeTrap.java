package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.SporeTrapEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;


public class SporeTrap<T extends SporeTrapEntity> extends SinglePartEntityModel<T> {
	private final ModelPart sporetrap;
	private final ModelPart head;

	public SporeTrap(ModelPart root) {
		this.sporetrap = root.getChild("sporetrap");
		this.head = sporetrap.getChild("body").getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData sporetrap = modelPartData.addChild("sporetrap", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 21.0F, 2.0F));

		ModelPartData back_leg_r = sporetrap.addChild("back_leg_r", ModelPartBuilder.create().uv(22, 23).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData back_right_foot = back_leg_r.addChild("back_right_foot", ModelPartBuilder.create().uv(0, 5).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.0F, -1.0F));

		ModelPartData front_leg_l = sporetrap.addChild("front_leg_l", ModelPartBuilder.create().uv(24, 4).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 0.0F, -4.0F));

		ModelPartData front_left_foot = front_leg_l.addChild("front_left_foot", ModelPartBuilder.create().uv(0, 4).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.0F, -1.0F));

		ModelPartData front_leg_r = sporetrap.addChild("front_leg_r", ModelPartBuilder.create().uv(0, 25).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -4.0F));

		ModelPartData front_right_foot = front_leg_r.addChild("front_right_foot", ModelPartBuilder.create().uv(11, 9).cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.0F, 0.0F));

		ModelPartData back_leg_l = sporetrap.addChild("back_leg_l", ModelPartBuilder.create().uv(14, 23).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 0.0F, 0.0F));

		ModelPartData back_left_foot = back_leg_l.addChild("back_left_foot", ModelPartBuilder.create().uv(11, 10).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.0F, -1.0F));

		ModelPartData body = sporetrap.addChild("body", ModelPartBuilder.create().uv(0, 15).cuboid(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 0.0F, -2.0F));

		ModelPartData back_bone = body.addChild("back_bone", ModelPartBuilder.create().uv(0, 5).cuboid(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 2.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -6.0F, 0.0F));

		ModelPartData top_jaw = head.addChild("top_jaw", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 2.0F));

		ModelPartData top_jaw_L = top_jaw.addChild("top_jaw_L", ModelPartBuilder.create().uv(12, 9).cuboid(-1.0F, -2.0F, -6.0F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -1.0F, 1.0F));

		ModelPartData front_L = top_jaw_L.addChild("front_L", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 0.0F, -6.0F));

		ModelPartData left = top_jaw_L.addChild("left", ModelPartBuilder.create().uv(12, 1).cuboid(0.0F, 0.0F, -3.0F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 0.0F, -3.0F));

		ModelPartData top_jaw_R = top_jaw.addChild("top_jaw_R", ModelPartBuilder.create().uv(0, 7).cuboid(-2.0F, -2.0F, -6.0F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -1.0F, 1.0F));

		ModelPartData right = top_jaw_R.addChild("right", ModelPartBuilder.create().uv(12, 11).cuboid(0.0F, 0.0F, -3.0F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 0.0F, -3.0F));

		ModelPartData front_R = top_jaw_R.addChild("front_R", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.0F, -6.0F));

		ModelPartData top_jaw_teeth = top_jaw.addChild("top_jaw_teeth", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 13.0F, -2.0F));

		ModelPartData bottom_jaw = head.addChild("bottom_jaw", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -1.0F, -6.0F, 6.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

		ModelPartData back_bottom_jaw = bottom_jaw.addChild("back_bottom_jaw", ModelPartBuilder.create().uv(18, 0).cuboid(-3.0F, -2.0F, 0.0F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

		ModelPartData right_bottom_tooth = bottom_jaw.addChild("right_bottom_tooth", ModelPartBuilder.create().uv(16, 15).cuboid(0.0F, -2.0F, -3.0F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -1.0F, -3.0F, 0.0F, 0.0F, -0.1745F));

		ModelPartData front_bottom_tooth = bottom_jaw.addChild("front_bottom_tooth", ModelPartBuilder.create().uv(18, 2).cuboid(-3.0F, -2.0F, 0.0F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, -6.0F, 0.1745F, 0.0F, 0.0F));

		ModelPartData left_bottom_tooth = bottom_jaw.addChild("left_bottom_tooth", ModelPartBuilder.create().uv(16, 13).cuboid(0.0F, -2.0F, -3.0F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -1.0F, -3.0F, 0.0F, 0.0F, 0.1745F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(SporeTrapEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.SPORETRAP_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.SPORETRAP_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.SPORETRAP_ATTACK, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -20.0f, 20.0f);
		headPitch = MathHelper.clamp(headPitch, -20.0f, 20.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		sporetrap.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return sporetrap;
	}
}