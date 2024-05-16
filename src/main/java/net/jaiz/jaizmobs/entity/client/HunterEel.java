package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.HunterEelEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class HunterEel<T extends HunterEelEntity> extends SinglePartEntityModel<T> {
	private final ModelPart hunter_eel;
	private final ModelPart head;

	public HunterEel(ModelPart root) {
		this.hunter_eel = root.getChild("hunter_eel");
		this.head = hunter_eel.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData hunter_eel = modelPartData.addChild("hunter_eel", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData head = hunter_eel.addChild("head", ModelPartBuilder.create().uv(13, 16).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 7.0F));

		ModelPartData bottom_jaw = head.addChild("bottom_jaw", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -0.2321F, -0.1703F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.2321F, 0.1703F));

		ModelPartData beard_r1 = bottom_jaw.addChild("beard_r1", ModelPartBuilder.create().uv(0, 24).cuboid(0.0F, -1.5F, -2.25F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.7679F, 3.8297F, -0.1745F, 0.0F, 0.0F));

		ModelPartData segment1 = hunter_eel.addChild("segment1", ModelPartBuilder.create().uv(17, 23).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(28, 7).cuboid(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(32, 22).cuboid(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 7.0F));

		ModelPartData segment2 = segment1.addChild("segment2", ModelPartBuilder.create().uv(28, 2).cuboid(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(32, 12).cuboid(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(7, 23).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

		ModelPartData segment3 = segment2.addChild("segment3", ModelPartBuilder.create().uv(27, 17).cuboid(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 32).cuboid(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(22, 15).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

		ModelPartData segment4 = segment3.addChild("segment4", ModelPartBuilder.create().uv(0, 27).cuboid(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(30, 30).cuboid(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(22, 0).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

		ModelPartData segment5 = segment4.addChild("segment5", ModelPartBuilder.create().uv(26, 25).cuboid(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(24, 30).cuboid(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 21).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

		ModelPartData segment6 = segment5.addChild("segment6", ModelPartBuilder.create().uv(20, 25).cuboid(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(18, 30).cuboid(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(18, 10).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

		ModelPartData segment7 = segment6.addChild("segment7", ModelPartBuilder.create().uv(14, 25).cuboid(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(18, 5).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(12, 30).cuboid(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

		ModelPartData segment8 = segment7.addChild("segment8", ModelPartBuilder.create().uv(8, 25).cuboid(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(12, 0).cuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(6, 30).cuboid(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

		ModelPartData segment9 = segment8.addChild("segment9", ModelPartBuilder.create().uv(32, 0).cuboid(-0.75F, -0.75F, -3.0F, 1.5F, 1.5F, 3.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(0.0F, -6.0F, -9.0F, 0.0F, 12.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.0F));
		return TexturedModelData.of(modelData, 42, 42);
	}

	@Override
	public void setAngles(HunterEelEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.HUNTER_EEL_SWIM, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.HUNTER_EEL_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.HUNTER_EEL_ATTACK, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -20.0f, 20.0f);
		headPitch = MathHelper.clamp(headPitch, -20.0f, 0.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		hunter_eel.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return hunter_eel;
	}

}