package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.VoidBullEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;


public class VoidBull<T extends VoidBullEntity> extends SinglePartEntityModel<T>  {
	private final ModelPart voidbull;
	private final ModelPart head;

	public VoidBull(ModelPart root) {
		this.voidbull = root.getChild("voidbull");
		this.head = voidbull.getChild("body").getChild("head");
	}


	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData voidbull = modelPartData.addChild("voidbull", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData body = voidbull.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -7.0F, -9.0F, 14.0F, 14.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -17.0F, 2.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(34, 43).cuboid(-4.0F, -2.5F, 0.3333F, 9.0F, 9.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, -0.5F, 8.6667F));

		ModelPartData horn_r_r1 = head.addChild("horn_r_r1", ModelPartBuilder.create().uv(46, 0).cuboid(-2.5F, -4.5F, -4.5F, 5.0F, 9.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -1.0F, 5.8333F, -0.3491F, 0.3491F, 0.0F));

		ModelPartData horn_l_r1 = head.addChild("horn_l_r1", ModelPartBuilder.create().uv(55, 23).cuboid(-2.5F, -4.5F, -4.5F, 5.0F, 9.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(5.5F, -1.0F, 5.8333F, -0.3491F, -0.3491F, 0.0F));

		ModelPartData body_2 = body.addChild("body_2", ModelPartBuilder.create().uv(0, 32).cuboid(-6.0F, -6.0F, -11.5F, 12.0F, 12.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -8.5F));

		ModelPartData body_3 = body_2.addChild("body_3", ModelPartBuilder.create().uv(0, 55).cuboid(-5.0F, -5.0F, -9.5F, 10.0F, 10.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -11.0F));

		ModelPartData body_4 = body_3.addChild("body_4", ModelPartBuilder.create().uv(38, 64).cuboid(-4.0F, -4.0F, -7.5F, 8.0F, 8.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -9.0F));

		ModelPartData body_5 = body_4.addChild("body_5", ModelPartBuilder.create().uv(74, 21).cuboid(-3.0F, -3.0F, -5.5F, 6.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -7.0F));

		ModelPartData tail_flukes = body_5.addChild("tail_flukes", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -5.0F));

		ModelPartData tail_fluke2_r1 = tail_flukes.addChild("tail_fluke2_r1", ModelPartBuilder.create().uv(0, 63).cuboid(0.0F, -4.0F, -50.0F, 0.0F, 8.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 38.5F, 0.0F, 0.0F, -0.7854F));

		ModelPartData tail_fluke1_r1 = tail_flukes.addChild("tail_fluke1_r1", ModelPartBuilder.create().uv(64, 30).cuboid(0.0F, -4.0F, -5.5F, 0.0F, 8.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData legs = voidbull.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData front_l = legs.addChild("front_l", ModelPartBuilder.create().uv(74, 0).cuboid(-4.5F, 0.0F, -2.5F, 5.0F, 16.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.5F, -16.0F, 5.5F));

		ModelPartData front_r = legs.addChild("front_r", ModelPartBuilder.create().uv(68, 64).cuboid(-0.5F, 0.0F, -2.5F, 5.0F, 16.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(6.5F, -16.0F, 5.5F));

		ModelPartData back_l = legs.addChild("back_l", ModelPartBuilder.create().uv(42, 79).cuboid(-16.0F, 0.0F, -2.5F, 5.0F, 14.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -14.0F, -10.5F));

		ModelPartData back_r = legs.addChild("back_r", ModelPartBuilder.create().uv(22, 74).cuboid(11.0F, 0.0F, -2.5F, 5.0F, 14.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, -14.0F, -10.5F));
		return TexturedModelData.of(modelData, 100, 100);
	}


	@Override
	public void setAngles(VoidBullEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.VOIDBULL_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.VOIDBULL_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.VOIDBULL_ATTACK, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -20.0f, 20.0f);
		headPitch = MathHelper.clamp(headPitch, -20.0f, 20.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		voidbull.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return voidbull;
	}

}