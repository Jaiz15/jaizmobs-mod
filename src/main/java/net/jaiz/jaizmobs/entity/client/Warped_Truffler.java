package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.WarpedTrufflerEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.model.ModelPart;

public class Warped_Truffler<T extends WarpedTrufflerEntity> extends SinglePartEntityModel<T> {
	private final ModelPart truffler;
	private final ModelPart head;

	public Warped_Truffler(ModelPart root) {
		this.truffler = root.getChild("truffler");
		this.head = truffler.getChild("body");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData truffler = modelPartData.addChild("truffler", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 22.0F, 0.0F));

		ModelPartData body = truffler.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -11.75F, -5.0F, 10.0F, 4.0F, 10.0F, new Dilation(0.0F))
				.uv(3, 14).cuboid(-2.0F, -7.75F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.25F, 0.0F));

		ModelPartData leg_r = truffler.addChild("leg_r", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, 0.0F, -1.5F));

		ModelPartData leg_r2 = truffler.addChild("leg_r2", ModelPartBuilder.create(), ModelTransform.pivot(1.5F, 0.0F, 1.5F));

		ModelPartData leg_l2 = truffler.addChild("leg_l2", ModelPartBuilder.create().uv(0, 4).cuboid(-1.0F, 0.0F, -0.75F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, 0.0F, -1.75F));

		ModelPartData leg_l3 = truffler.addChild("leg_l3", ModelPartBuilder.create().uv(0, 4).cuboid(-1.0F, 0.0F, -0.75F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, 0.0F, 1.25F));

		ModelPartData leg_r3 = truffler.addChild("leg_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, 0.0F, 1.5F));
		return TexturedModelData.of(modelData, 44, 44);
	}

	@Override
	public void setAngles(WarpedTrufflerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.TRUFFLER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.TRUFFLER_IDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -10.0f, 10.0f);
		headPitch = MathHelper.clamp(headPitch, -10.0f, 10.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		truffler.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return truffler;
	}


}