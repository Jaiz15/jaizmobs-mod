package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.CalciteGolemEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class Calcite_Golem<T extends CalciteGolemEntity> extends SinglePartEntityModel<T> {
	private final ModelPart calcite_golem;
	private final ModelPart head;

	public Calcite_Golem(ModelPart root) {
		this.calcite_golem = root.getChild("calcite_golem");
		this.head = calcite_golem.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData calcite_golem = modelPartData.addChild("calcite_golem", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData leg_l = calcite_golem.addChild("leg_l", ModelPartBuilder.create().uv(0, 27).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(1.75F, -4.0F, -0.5F));

		ModelPartData leg_r = calcite_golem.addChild("leg_r", ModelPartBuilder.create().uv(24, 0).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.75F, -4.0F, -0.5F));

		ModelPartData body = calcite_golem.addChild("body", ModelPartBuilder.create().uv(0, 15).cuboid(-3.5F, -7.0F, -2.5F, 7.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, -0.5F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, -4.0F, -5.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 0.0F));

		ModelPartData arm_r = body.addChild("arm_r", ModelPartBuilder.create().uv(24, 15).cuboid(-2.0F, -0.75F, -1.5F, 2.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.5F, -5.0F, 0.0F));

		ModelPartData arm_l = body.addChild("arm_l", ModelPartBuilder.create().uv(21, 26).cuboid(0.0F, -0.75F, -1.5F, 2.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5F, -5.0F, 0.0F));
		return TexturedModelData.of(modelData, 40, 40);
	}
	@Override
	public void setAngles(CalciteGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.CALCITE_GOLEM_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.CALCITE_GOLEM_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.CALCITE_GOLEM_ATTACK, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -20.0f, 20.0f);
		headPitch = MathHelper.clamp(headPitch, -20.0f, 20.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		calcite_golem.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return calcite_golem;
	}

}