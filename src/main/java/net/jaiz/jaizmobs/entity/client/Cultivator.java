package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.CultivatorEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class Cultivator<T extends CultivatorEntity> extends SinglePartEntityModel<T> {
	private final ModelPart cultivator;
	private final ModelPart head;

	public Cultivator(ModelPart root) {
		this.cultivator = root.getChild("cultivator");
		this.head = cultivator.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData cultivator = modelPartData.addChild("cultivator", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = cultivator.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-9.0F, -7.75F, -14.0F, 18.0F, 13.0F, 28.0F, new Dilation(0.0F))
		.uv(0, 41).cuboid(-7.0F, -9.75F, -12.0F, 14.0F, 2.0F, 24.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.25F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.25F, -14.0F));

		ModelPartData top_jaw = head.addChild("top_jaw", ModelPartBuilder.create().uv(66, 62).cuboid(-5.0F, -3.0F, -10.0F, 10.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData bottom_jaw = head.addChild("bottom_jaw", ModelPartBuilder.create().uv(64, 0).cuboid(-6.0F, -0.75F, -10.75F, 12.0F, 5.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.25F, -0.25F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(52, 41).cuboid(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.25F, 14.0F));

		ModelPartData tail_2 = tail.addChild("tail_2", ModelPartBuilder.create().uv(0, 67).cuboid(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 11.0F));

		ModelPartData pod15 = tail_2.addChild("pod15", ModelPartBuilder.create().uv(94, 84).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(15, 10).cuboid(0.0F, -5.0F, -1.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 3.5F));

		ModelPartData tiny_plant2_r1 = pod15.addChild("tiny_plant2_r1", ModelPartBuilder.create().uv(0, 13).cuboid(0.0F, -0.5F, -1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.5F, 4.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod16 = tail_2.addChild("pod16", ModelPartBuilder.create().uv(15, 13).cuboid(0.0F, -3.5F, -1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(15, 41).cuboid(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.5F, 7.5F));

		ModelPartData tiny_plant4_r1 = pod16.addChild("tiny_plant4_r1", ModelPartBuilder.create().uv(0, 10).cuboid(0.0F, -1.5F, -1.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0F, -4.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData tail_3 = tail_2.addChild("tail_3", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 9.0F));

		ModelPartData pod14 = tail.addChild("pod14", ModelPartBuilder.create().uv(69, 90).cuboid(-1.5F, -4.0F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F))
		.uv(64, 67).cuboid(-1.5F, -9.0F, 0.0F, 3.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 8.5F));

		ModelPartData small_plant15_r1 = pod14.addChild("small_plant15_r1", ModelPartBuilder.create().uv(31, 67).cuboid(-1.5F, -1.0F, 0.0F, 3.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod13 = tail.addChild("pod13", ModelPartBuilder.create().uv(0, 57).cuboid(-1.5F, -4.5F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F))
		.uv(96, 65).cuboid(-1.5F, -10.5F, 0.0F, 3.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.5F, 3.5F));

		ModelPartData small_plant13_r1 = pod13.addChild("small_plant13_r1", ModelPartBuilder.create().uv(64, 97).cuboid(-1.5F, -2.0F, 0.0F, 3.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pods = body.addChild("pods", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.25F, 0.0F));

		ModelPartData pod1 = pods.addChild("pod1", ModelPartBuilder.create().uv(32, 94).cuboid(-2.0F, -16.75F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -21.0F, 1.0F));

		ModelPartData plant2_r1 = pod1.addChild("plant2_r1", ModelPartBuilder.create().uv(56, 92).cuboid(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -12.75F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod1_r1 = pod1.addChild("pod1_r1", ModelPartBuilder.create().uv(72, 76).cuboid(-2.0F, -5.0F, -2.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData pod2 = pods.addChild("pod2", ModelPartBuilder.create().uv(16, 83).cuboid(-2.0F, -8.5F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F))
		.uv(92, 36).cuboid(-2.0F, -16.5F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -20.5F, 5.0F));

		ModelPartData plant4_r1 = pod2.addChild("plant4_r1", ModelPartBuilder.create().uv(48, 92).cuboid(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -12.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod3 = pods.addChild("pod3", ModelPartBuilder.create().uv(80, 16).cuboid(-2.0F, -7.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F))
		.uv(23, 67).cuboid(-2.0F, -15.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -21.0F, 9.0F));

		ModelPartData plant6_r1 = pod3.addChild("plant6_r1", ModelPartBuilder.create().uv(92, 28).cuboid(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod4 = pods.addChild("pod4", ModelPartBuilder.create().uv(52, 41).cuboid(-2.0F, -17.5F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 83).cuboid(-2.0F, -9.5F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(5.5F, -19.5F, -6.5F));

		ModelPartData plant9_r1 = pod4.addChild("plant9_r1", ModelPartBuilder.create().uv(20, 20).cuboid(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -13.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod5 = pods.addChild("pod5", ModelPartBuilder.create().uv(64, 16).cuboid(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F))
		.uv(64, 0).cuboid(-2.0F, -17.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -19.0F, -3.0F));

		ModelPartData plant8_r1 = pod5.addChild("plant8_r1", ModelPartBuilder.create().uv(0, 67).cuboid(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -13.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod6 = pods.addChild("pod6", ModelPartBuilder.create().uv(32, 83).cuboid(-2.0F, -6.5F, -2.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F))
		.uv(20, 12).cuboid(-2.0F, -14.5F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -20.5F, -9.0F));

		ModelPartData plant11_r1 = pod6.addChild("plant11_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -10.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod7 = pods.addChild("pod7", ModelPartBuilder.create().uv(88, 76).cuboid(-1.5F, -4.5F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F))
		.uv(96, 16).cuboid(-1.5F, -12.5F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(6.5F, -19.5F, 4.5F));

		ModelPartData small_plant4_r1 = pod7.addChild("small_plant4_r1", ModelPartBuilder.create().uv(18, 96).cuboid(-1.5F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod8 = pods.addChild("pod8", ModelPartBuilder.create().uv(16, 0).cuboid(-1.5F, -3.5F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F))
		.uv(96, 57).cuboid(-1.5F, -11.5F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(4.5F, -20.0F, -11.5F));

		ModelPartData small_plant2_r1 = pod8.addChild("small_plant2_r1", ModelPartBuilder.create().uv(24, 96).cuboid(-1.5F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod9 = pods.addChild("pod9", ModelPartBuilder.create().uv(52, 67).cuboid(-1.5F, -7.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F))
		.uv(6, 96).cuboid(-1.5F, -15.0F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(6.5F, -19.0F, -1.5F));

		ModelPartData small_plant6_r1 = pod9.addChild("small_plant6_r1", ModelPartBuilder.create().uv(12, 96).cuboid(-1.5F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod10 = pods.addChild("pod10", ModelPartBuilder.create().uv(85, 87).cuboid(-1.5F, -5.5F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F))
		.uv(93, 95).cuboid(-1.5F, -13.5F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -19.5F, 11.5F));

		ModelPartData small_plant7_r1 = pod10.addChild("small_plant7_r1", ModelPartBuilder.create().uv(0, 96).cuboid(-1.5F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -9.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod11 = pods.addChild("pod11", ModelPartBuilder.create().uv(83, 41).cuboid(-1.5F, -5.5F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F))
		.uv(81, 95).cuboid(-1.5F, -13.5F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.5F, -19.5F, 1.0F));

		ModelPartData small_plant9_r1 = pod11.addChild("small_plant9_r1", ModelPartBuilder.create().uv(87, 95).cuboid(-1.5F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -9.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod12 = pods.addChild("pod12", ModelPartBuilder.create().uv(40, 94).cuboid(-1.5F, -12.5F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -20.5F, -9.5F));

		ModelPartData small_plant11_r1 = pod12.addChild("small_plant11_r1", ModelPartBuilder.create().uv(94, 49).cuboid(-1.5F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData pod12_r1 = pod12.addChild("pod12_r1", ModelPartBuilder.create().uv(12, 57).cuboid(-1.5F, -4.5F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData legs = cultivator.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData front_l = legs.addChild("front_l", ModelPartBuilder.create().uv(52, 76).cuboid(-1.5F, -1.5F, -2.5F, 5.0F, 11.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(9.5F, -9.5F, -8.5F));

		ModelPartData back_l = legs.addChild("back_l", ModelPartBuilder.create().uv(32, 67).cuboid(-1.5F, -1.5F, -2.5F, 5.0F, 11.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(9.5F, -9.5F, 8.5F));

		ModelPartData front_r = legs.addChild("front_r", ModelPartBuilder.create().uv(0, 12).cuboid(-3.5F, -1.5F, -2.5F, 5.0F, 11.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.5F, -9.5F, -8.5F));

		ModelPartData back_r = legs.addChild("back_r", ModelPartBuilder.create().uv(0, 41).cuboid(-3.5F, -1.5F, -2.5F, 5.0F, 11.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.5F, -9.5F, 8.5F));
		return TexturedModelData.of(modelData, 112, 112);
	}

	@Override
	public void setAngles(CultivatorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.CULTIVATOR_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.CULTIVATOR_IDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -20.0f, 20.0f);
		headPitch = MathHelper.clamp(headPitch, -20.0f, 20.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		cultivator.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return cultivator;
	}

}