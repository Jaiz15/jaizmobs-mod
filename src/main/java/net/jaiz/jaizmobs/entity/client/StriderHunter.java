package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.StriderHunterEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class StriderHunter<T extends StriderHunterEntity> extends SinglePartEntityModel<T> {
	private final ModelPart striderhunter;
	private final ModelPart head;

	public StriderHunter(ModelPart root) {
		this.striderhunter = root.getChild("striderhunter");
		this.head = striderhunter.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData striderhunter = modelPartData.addChild("striderhunter", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 14.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData body = striderhunter.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -4.3846F, 5.6538F, 16.0F, 16.0F, 30.0F, new Dilation(0.0F))
				.uv(0, 16).cuboid(0.0F, -12.3846F, 5.6538F, 0.0F, 8.0F, 30.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -20.6154F, -3.6538F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(88, 37).cuboid(-5.0F, -5.0F, -0.0167F, 10.0F, 10.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.6154F, 35.6705F));

		ModelPartData jaw_l = head.addChild("jaw_l", ModelPartBuilder.create().uv(78, 74).cuboid(-5.0F, -2.5F, -1.0167F, 8.0F, 5.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 1.5F, 8.0F));

		ModelPartData jaw_r = head.addChild("jaw_r", ModelPartBuilder.create().uv(0, 86).cuboid(-3.0F, -2.5F, -1.0167F, 8.0F, 5.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 1.5F, 8.0F));

		ModelPartData body2 = body.addChild("body2", ModelPartBuilder.create().uv(40, 80).cuboid(0.0F, -14.5F, -14.0F, 0.0F, 8.0F, 14.0F, new Dilation(0.0F))
				.uv(46, 46).cuboid(-7.0F, -6.5F, -14.0F, 14.0F, 14.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.1154F, 5.6538F));

		ModelPartData body3 = body2.addChild("body3", ModelPartBuilder.create().uv(78, 77).cuboid(0.0F, -13.3846F, -13.9462F, 0.0F, 8.0F, 14.0F, new Dilation(0.0F))
				.uv(0, 60).cuboid(-6.0F, -5.3846F, -13.9462F, 12.0F, 12.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.1154F, -14.0538F));

		ModelPartData body4 = body3.addChild("body4", ModelPartBuilder.create().uv(0, 8).cuboid(0.0F, -12.3846F, -13.9962F, 0.0F, 8.0F, 14.0F, new Dilation(0.0F))
				.uv(62, 0).cuboid(-4.5F, -4.3846F, -13.9962F, 9.0F, 9.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -13.95F));

		ModelPartData body5 = body4.addChild("body5", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -10.4846F, -13.9962F, 0.0F, 8.0F, 14.0F, new Dilation(0.0F))
				.uv(38, 74).cuboid(-3.0F, -2.9846F, -13.9962F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.1F, -14.0F));

		ModelPartData legs = striderhunter.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData legs_l = legs.addChild("legs_l", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData front_l = legs_l.addChild("front_l", ModelPartBuilder.create().uv(0, 103).cuboid(-1.5F, -1.5F, -2.5F, 5.0F, 17.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-10.5F, -15.5F, 25.5F));

		ModelPartData mid_l = legs_l.addChild("mid_l", ModelPartBuilder.create().uv(35, 102).cuboid(-1.5F, -1.5F, -2.5F, 5.0F, 17.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-10.5F, -15.5F, 10.5F));

		ModelPartData back_l = legs_l.addChild("back_l", ModelPartBuilder.create().uv(103, 94).cuboid(-1.5F, -2.0F, -2.5F, 5.0F, 14.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.5F, -12.0F, -1.5F));

		ModelPartData legs_r = legs.addChild("legs_r", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData front_r = legs_r.addChild("front_r", ModelPartBuilder.create().uv(63, 97).cuboid(-3.5F, -1.5F, -2.5F, 5.0F, 17.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(10.5F, -15.5F, 25.5F));

		ModelPartData mid_r = legs_r.addChild("mid_r", ModelPartBuilder.create().uv(83, 99).cuboid(-3.5F, -1.5F, -2.5F, 5.0F, 17.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(10.5F, -15.5F, 10.5F));

		ModelPartData back_r = legs_r.addChild("back_r", ModelPartBuilder.create().uv(103, 18).cuboid(-3.5F, -2.0F, -2.5F, 5.0F, 14.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(9.5F, -12.0F, -1.5F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(StriderHunterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.STRIDER_HUNTER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.STRIDER_HUNTER_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.STRIDER_HUNTER_ATTACK, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -20.0f, 20.0f);
		headPitch = MathHelper.clamp(headPitch, -20.0f, 20.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		striderhunter.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return striderhunter;
	}
}