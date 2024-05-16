package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.AeroblobEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class Aeroblob<T extends AeroblobEntity> extends SinglePartEntityModel<T> {
	private final ModelPart aeroblob;
	private final ModelPart head;

	public Aeroblob(ModelPart root) {
		this.aeroblob = root.getChild("aeroblob");
		this.head = aeroblob.getChild("body").getChild("head");
	}


	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData aeroblob = modelPartData.addChild("aeroblob", ModelPartBuilder.create(), ModelTransform.of(0.0F, 14.0F, 3.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData body = aeroblob.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, 1.125F, -4.6667F, 7.0F, 3.0F, 6.0F, new Dilation(1.0F))
				.uv(9, 44).cuboid(-2.0F, 1.125F, -12.6667F, 4.0F, 1.0F, 3.0F, new Dilation(1.0F))
				.uv(0, 9).cuboid(-3.0F, 1.125F, -9.6667F, 6.0F, 2.0F, 6.0F, new Dilation(1.0F))
				.uv(49, 43).cuboid(-5.0F, 1.125F, 3.3333F, 10.0F, 4.0F, 7.0F, new Dilation(1.0F))
				.uv(0, 43).cuboid(-6.0F, -8.125F, -10.6667F, 12.0F, 9.0F, 25.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-8.0F, -17.875F, -11.6667F, 16.0F, 14.0F, 29.0F, new Dilation(4.0F)), ModelTransform.pivot(0.0F, 3.875F, -5.3333F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 17).cuboid(-3.0F, -14.0F, 7.0F, 6.0F, 3.0F, 5.0F, new Dilation(1.0F)), ModelTransform.pivot(0.0F, 15.125F, 5.3333F));

		ModelPartData tentacles = body.addChild("tentacles", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 15.125F, 5.3333F));

		ModelPartData T1 = tentacles.addChild("1", ModelPartBuilder.create().uv(14, 18).cuboid(0.0F, 0.0F, -3.5F, 0.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -10.0F, 2.5F));

		ModelPartData T2 = tentacles.addChild("2", ModelPartBuilder.create().uv(0, 18).cuboid(0.0F, 0.0F, -3.5F, 0.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -10.0F, 2.5F));

		ModelPartData T3 = tentacles.addChild("3", ModelPartBuilder.create().uv(0, 37).cuboid(0.0F, 0.0F, -3.0F, 0.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, -11.0F, -4.0F));

		ModelPartData T4 = tentacles.addChild("4", ModelPartBuilder.create().uv(17, 11).cuboid(0.0F, 0.0F, -3.0F, 0.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, -11.0F, -4.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}


	@Override
	public void setAngles(AeroblobEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.AEROBLOB_FLY, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.AEROBLOB_IDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -20.0f, 20.0f);
		headPitch = MathHelper.clamp(headPitch, -20.0f, 20.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		aeroblob.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return aeroblob;
	}

}