package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.KlephtopodEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class Klephtopod<T extends KlephtopodEntity> extends SinglePartEntityModel<T> {
	private final ModelPart klephtopod;
	private final ModelPart head;

	public Klephtopod(ModelPart root) {
		this.klephtopod = root.getChild("klephtopod");
		this.head = klephtopod.getChild("body").getChild("neck").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Klephtopod = modelPartData.addChild("klephtopod", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = Klephtopod.addChild("body", ModelPartBuilder.create().uv(0, 27).cuboid(-7.0F, 1.25F, -8.0F, 14.0F, 4.0F, 16.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-8.0F, -7.75F, -9.0F, 16.0F, 9.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.25F, 1.0F));

		ModelPartData neck = body.addChild("neck", ModelPartBuilder.create().uv(0, 53).cuboid(0.0F, -5.75F, -12.1667F, 0.0F, 3.0F, 12.0F, new Dilation(0.0F))
				.uv(0, 47).cuboid(-2.5F, 0.25F, -12.6667F, 5.0F, 3.0F, 15.0F, new Dilation(0.0F))
				.uv(45, 32).cuboid(-3.0F, -2.75F, -12.6667F, 6.0F, 3.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, -8.8333F, -0.7854F, 0.0F, 0.0F));

		ModelPartData head = neck.addChild("head", ModelPartBuilder.create().uv(63, 58).cuboid(-3.0F, -2.375F, -11.0F, 6.0F, 5.0F, 4.0F, new Dilation(0.0F))
				.uv(33, 58).cuboid(-4.0F, -3.875F, -7.0F, 8.0F, 7.5F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.375F, -12.1667F, 0.7854F, 0.0F, 0.0F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(57, 16).cuboid(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.25F, 8.0F));

		ModelPartData tail_end = tail.addChild("tail_end", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 8.0F));

		ModelPartData legs = body.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.75F, 0.0F));

		ModelPartData leg_1_front = legs.addChild("leg_1_front", ModelPartBuilder.create().uv(47, 50).cuboid(-1.0F, 0.75F, -1.5F, 15.0F, 0.0F, 8.0F, new Dilation(0.0F))
				.uv(72, 37).cuboid(-1.0F, -2.25F, -1.5F, 7.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 0.75F, -4.5F));

		ModelPartData leg_1_back = legs.addChild("leg_1_back", ModelPartBuilder.create().uv(72, 31).cuboid(-1.0F, -2.25F, -1.5F, 7.0F, 3.0F, 3.0F, new Dilation(0.0F))
				.uv(17, 50).cuboid(-1.0F, 0.75F, -1.5F, 15.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 0.75F, 4.5F));

		ModelPartData leg_r_front = legs.addChild("leg_r_front", ModelPartBuilder.create().uv(42, 8).cuboid(-14.0F, 0.75F, -1.5F, 15.0F, 0.0F, 8.0F, new Dilation(0.0F))
				.uv(0, 68).cuboid(-6.0F, -2.25F, -1.5F, 7.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, 0.75F, -4.5F));

		ModelPartData leg_r_back = legs.addChild("leg_r_back", ModelPartBuilder.create().uv(63, 67).cuboid(-6.0F, -2.25F, -1.5F, 7.0F, 3.0F, 3.0F, new Dilation(0.0F))
				.uv(42, 0).cuboid(-14.0F, 0.75F, -1.5F, 15.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, 0.75F, 4.5F));
		return TexturedModelData.of(modelData, 96, 96);
	}

	@Override
	public void setAngles(KlephtopodEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.KLEPHTOPOD_SWIM, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.KLEPHTOPOD_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.KLEPHTOPOD_ATTACK, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -10.0f, 10.0f);
		headPitch = MathHelper.clamp(headPitch, 50.0f, 110.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		klephtopod.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return klephtopod;
	}

}