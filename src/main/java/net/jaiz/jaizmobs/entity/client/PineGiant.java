package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.PineGiantEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class PineGiant<T extends PineGiantEntity> extends SinglePartEntityModel<T> {
	private final ModelPart pine_giant;
	private final ModelPart head;

	public PineGiant(ModelPart root) {
		this.pine_giant = root.getChild("pine_giant");
		this.head = pine_giant.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData pine_giant = modelPartData.addChild("pine_giant", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData body = pine_giant.addChild("body", ModelPartBuilder.create().uv(0, 37).cuboid(-5.0F, -16.5F, -3.0F, 10.0F, 17.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -37.5F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(13, 80).cuboid(-6.0F, -10.0F, -5.0F, 12.0F, 10.0F, 10.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-9.0F, -10.0F, -9.0F, 18.0F, 5.0F, 18.0F, new Dilation(0.0F))
				.uv(12, 75).cuboid(-1.5F, -11.0F, -1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -16.5F, 0.0F));

		ModelPartData arm_r = body.addChild("arm_r", ModelPartBuilder.create().uv(44, 23).cuboid(0.0F, 0.0F, -1.5F, 3.0F, 37.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -15.5F, 0.0F));

		ModelPartData mushrooms_r = arm_r.addChild("mushrooms_r", ModelPartBuilder.create().uv(62, 12).cuboid(8.0F, -28.0F, 1.5F, 4.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, 53.0F, 0.0F));

		ModelPartData mushroom_r1 = mushrooms_r.addChild("mushroom_r1", ModelPartBuilder.create().uv(8, 5).cuboid(-1.0F, -1.5F, 1.0F, 4.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, -50.5F, -2.5F, 0.0F, 0.0F, 0.0F));

		ModelPartData mushroom_r2 = mushrooms_r.addChild("mushroom_r2", ModelPartBuilder.create().uv(34, 28).cuboid(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(10.0F, -37.5F, -1.5F, 0.0F, 3.1416F, 0.0F));

		ModelPartData mushroom_r3 = mushrooms_r.addChild("mushroom_r3", ModelPartBuilder.create().uv(8, 0).cuboid(-1.0F, 20.5F, -1.0F, 4.0F, 5.0F, 0.0F, new Dilation(0.0F))
				.uv(34, 23).cuboid(-1.0F, 0.5F, -1.0F, 4.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, -50.5F, -2.5F, 0.0F, 1.5708F, 0.0F));

		ModelPartData mushroom_r4 = mushrooms_r.addChild("mushroom_r4", ModelPartBuilder.create().uv(54, 12).cuboid(0.0F, 4.5F, 2.0F, 4.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(10.0F, -50.5F, 1.5F, 0.0F, -1.5708F, 0.0F));

		ModelPartData arm_l = body.addChild("arm_l", ModelPartBuilder.create().uv(32, 37).cuboid(-3.0F, 0.0F, -1.5F, 3.0F, 37.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -15.5F, 0.0F));

		ModelPartData mushrooms_l = arm_l.addChild("mushrooms_l", ModelPartBuilder.create().uv(0, 10).cuboid(-12.0F, -41.0F, 1.5F, 4.0F, 5.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 5).cuboid(-12.0F, -25.0F, 1.5F, 4.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 53.0F, 0.0F));

		ModelPartData mushroom_r5 = mushrooms_l.addChild("mushroom_r5", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -25.5F, -3.5F, 0.0F, -1.5708F, 0.0F));

		ModelPartData mushroom_r6 = mushrooms_l.addChild("mushroom_r6", ModelPartBuilder.create().uv(0, 23).cuboid(1.5F, 13.5F, -1.0F, 4.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -50.5F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData mushroom_r7 = mushrooms_l.addChild("mushroom_r7", ModelPartBuilder.create().uv(8, 10).cuboid(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -27.5F, 3.5F, 0.0F, 1.5708F, 0.0F));

		ModelPartData mushroom_r8 = mushrooms_l.addChild("mushroom_r8", ModelPartBuilder.create().uv(0, 28).cuboid(-1.0F, 1.5F, -1.5F, 4.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-11.0F, -50.5F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData leg_l = pine_giant.addChild("leg_l", ModelPartBuilder.create().uv(54, 0).cuboid(-2.0F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, new Dilation(0.0F))
				.uv(56, 23).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 37.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -37.0F, 0.0F));

		ModelPartData leg_r = pine_giant.addChild("leg_r", ModelPartBuilder.create().uv(0, 60).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 37.0F, 3.0F, new Dilation(0.0F))
				.uv(12, 60).cuboid(-3.0F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -37.0F, 0.0F));
		return TexturedModelData.of(modelData, 100, 100);
	}
	@Override
	public void setAngles(PineGiantEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.PINE_GIANT_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.PINE_GIANT_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.PINE_GIANT_ATTACK, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -20.0f, 20.0f);
		headPitch = MathHelper.clamp(headPitch, -80.0f, 0.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		pine_giant.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return pine_giant;
	}
}