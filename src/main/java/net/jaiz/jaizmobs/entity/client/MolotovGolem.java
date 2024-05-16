package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.MolotovGolemEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;


public class MolotovGolem<T extends MolotovGolemEntity> extends SinglePartEntityModel<T> {
	private final ModelPart molotov_golem;
	private final ModelPart head;

	public MolotovGolem(ModelPart root) {
		this.molotov_golem = root.getChild("molotov_golem");
		this.head = molotov_golem.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData molotov_golem = modelPartData.addChild("molotov_golem", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = molotov_golem.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -5.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.0F, 0.0F));

		ModelPartData bottom_jaw = head.addChild("bottom_jaw", ModelPartBuilder.create().uv(24, 38).cuboid(-4.0F, -2.0F, -7.0F, 8.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(34, 28).cuboid(-4.0F, -1.0F, -7.0F, 8.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 3.0F));

		ModelPartData top_jaw = head.addChild("top_jaw", ModelPartBuilder.create().uv(17, 47).cuboid(-3.5F, -4.0F, -7.0F, 7.0F, 4.0F, 7.0F, new Dilation(0.0F))
		.uv(18, 0).cuboid(-4.0F, -4.2F, -7.5F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 4.0F));

		ModelPartData chest_1 = body.addChild("chest_1", ModelPartBuilder.create().uv(36, 0).cuboid(0.0F, -8.0F, -6.0F, 6.0F, 15.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

		ModelPartData chest_2 = body.addChild("chest_2", ModelPartBuilder.create().uv(0, 30).cuboid(0.0F, -8.0F, 0.0F, 6.0F, 15.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

		ModelPartData chest_3 = body.addChild("chest_3", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -8.0F, -6.0F, 6.0F, 15.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

		ModelPartData chest_4 = body.addChild("chest_4", ModelPartBuilder.create().uv(18, 15).cuboid(-6.0F, -8.0F, 0.0F, 6.0F, 15.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

		ModelPartData arm_l = body.addChild("arm_l", ModelPartBuilder.create().uv(0, 51).cuboid(0.0F, -1.5F, -2.5F, 3.0F, 14.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -13.0F, 0.0F));

		ModelPartData arm_r = body.addChild("arm_r", ModelPartBuilder.create(), ModelTransform.pivot(-6.0F, -13.0F, 0.0F));

		ModelPartData arm_r_r1 = arm_r.addChild("arm_r_r1", ModelPartBuilder.create().uv(45, 47).cuboid(-1.5F, -7.0F, -2.5F, 3.0F, 14.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, 5.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData heart = body.addChild("heart", ModelPartBuilder.create().uv(58, 26).cuboid(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData leg_l = molotov_golem.addChild("leg_l", ModelPartBuilder.create().uv(56, 38).cuboid(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -5.0F, 0.0F));

		ModelPartData leg_r = molotov_golem.addChild("leg_r", ModelPartBuilder.create().uv(55, 16).cuboid(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, -5.0F, 0.0F));
		return TexturedModelData.of(modelData, 96, 96);
	}


	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -20.0f, 20.0f);
		headPitch = MathHelper.clamp(headPitch, -20.0f, 20.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void setAngles(MolotovGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.MOLOTOV_GOLEM_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.MOLOTOV_GOLEM_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.MOLTOV_GOLEM_ATTACK, ageInTicks, 1f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		molotov_golem.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return molotov_golem;
	}


}