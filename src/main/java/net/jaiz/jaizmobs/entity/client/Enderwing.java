package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.EnderwingEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class Enderwing<T extends EnderwingEntity> extends SinglePartEntityModel<T> {
	private final ModelPart enderwing;
	private final ModelPart head;

	public Enderwing(ModelPart root) {
		this.enderwing = root.getChild("enderwing");
		this.head = enderwing.getChild("body");}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData enderwing = modelPartData.addChild("enderwing", ModelPartBuilder.create(), ModelTransform.of(0.0F, 31.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData body = enderwing.addChild("body", ModelPartBuilder.create().uv(0, 50).cuboid(-8.0F, -3.0F, -8.0F, 16.0F, 6.0F, 21.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.0F, 0.0F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(81, 82).cuboid(-3.0F, -3.0F, -11.0F, 6.0F, 6.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -8.0F));

		ModelPartData tail_2 = tail.addChild("tail_2", ModelPartBuilder.create().uv(89, 0).cuboid(-2.0F, -2.0F, -11.0F, 4.0F, 4.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -11.0F));

		ModelPartData tail_3 = tail_2.addChild("tail_3", ModelPartBuilder.create().uv(89, 15).cuboid(-1.0F, -1.0F, -11.0F, 2.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -11.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 77).cuboid(-6.0F, -3.0F, -1.0F, 12.0F, 5.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 13.0F));

		ModelPartData bottom_jaw = head.addChild("bottom_jaw", ModelPartBuilder.create().uv(46, 80).cuboid(-6.0F, 0.0F, 0.0F, 12.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, -1.0F));

		ModelPartData wing_l = body.addChild("wing_l", ModelPartBuilder.create().uv(53, 56).cuboid(-11.0F, -1.0F, -8.0F, 11.0F, 3.0F, 21.0F, new Dilation(0.0F))
				.uv(0, 25).cuboid(-32.0F, -1.0F, -12.0F, 32.0F, 0.0F, 25.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, -2.0F, 0.0F));

		ModelPartData wing_r = body.addChild("wing_r", ModelPartBuilder.create().uv(68, 29).cuboid(0.0F, -1.0F, -8.0F, 11.0F, 3.0F, 21.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(0.0F, -1.0F, -12.0F, 32.0F, 0.0F, 25.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, -2.0F, 0.0F));
		return TexturedModelData.of(modelData, 152, 152);
	}
	@Override
	public void setAngles(EnderwingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.ENDERWING_FLY, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.ENDERWING_FLY, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.ENDERWING_ATTACK, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -60.0f, 60.0f);
		headPitch = MathHelper.clamp(headPitch, -60.0f, 60.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		enderwing.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return enderwing;
	}
}