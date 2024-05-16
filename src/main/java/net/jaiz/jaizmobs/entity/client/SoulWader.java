package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.SoulWaderEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class SoulWader<T extends SoulWaderEntity> extends SinglePartEntityModel<T> {
	private final ModelPart soul_wader;
	private final ModelPart head;

	public SoulWader(ModelPart root) {
		this.soul_wader = root.getChild("soul_wader");
		this.head = soul_wader.getChild("body").getChild("neck").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData soul_wader = modelPartData.addChild("soul_wader", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 26.0F, 0.0F));

		ModelPartData body = soul_wader.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -13.0F, -23.5F, 16.0F, 13.0F, 31.0F, new Dilation(0.0F))
		.uv(0, 44).cuboid(-8.5F, -13.5F, -24.0F, 17.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -58.0F, 8.5F));

		ModelPartData neck = body.addChild("neck", ModelPartBuilder.create().uv(66, 44).cuboid(-3.0F, -42.5F, -2.5F, 6.0F, 55.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.5F, -23.0F));

		ModelPartData head = neck.addChild("head", ModelPartBuilder.create().uv(63, 0).cuboid(-5.0F, -4.5F, -10.6667F, 10.0F, 9.0F, 14.0F, new Dilation(0.0F))
		.uv(104, 109).cuboid(-4.0F, -3.5F, -18.6667F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(100, 53).cuboid(-4.0F, -3.5F, -9.1667F, 8.0F, 6.0F, 12.0F, new Dilation(0.0F))
		.uv(124, 19).cuboid(-3.0F, -3.25F, -17.1667F, 6.0F, 5.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -45.0F, 0.1667F));

		ModelPartData mane = neck.addChild("mane", ModelPartBuilder.create().uv(0, 76).cuboid(-0.5F, -23.0F, -0.5F, 1.0F, 46.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -23.5F, 2.5F));

		ModelPartData beard = neck.addChild("beard", ModelPartBuilder.create().uv(24, 71).cuboid(0.0F, -27.5F, -5.0F, 0.0F, 55.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -15.0F, -2.5F));

		ModelPartData legs = soul_wader.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -62.0F, -2.0F));

		ModelPartData l_front = legs.addChild("l_front", ModelPartBuilder.create().uv(34, 106).cuboid(-3.0F, -2.0F, -3.0F, 6.0F, 20.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, -3.0F, -9.0F));

		ModelPartData l_front2 = l_front.addChild("l_front2", ModelPartBuilder.create().uv(88, 94).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 47.0F, 3.0F, new Dilation(0.0F))
		.uv(50, 44).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.0F, 0.0F));

		ModelPartData l_back = legs.addChild("l_back", ModelPartBuilder.create().uv(100, 23).cuboid(-3.0F, -3.0F, -5.0F, 6.0F, 20.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 2.0F, 11.0F));

		ModelPartData l_back2 = l_back.addChild("l_back2", ModelPartBuilder.create().uv(63, 104).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 43.0F, 3.0F, new Dilation(0.0F))
		.uv(111, 6).cuboid(-2.0F, -1.0F, -3.0F, 4.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 17.0F, 0.0F));

		ModelPartData r_front = legs.addChild("r_front", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -2.0F, -3.0F, 6.0F, 20.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, -3.0F, -9.0F));

		ModelPartData r_front2 = r_front.addChild("r_front2", ModelPartBuilder.create().uv(88, 44).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 47.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 44).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.0F, 0.0F));

		ModelPartData r_back = legs.addChild("r_back", ModelPartBuilder.create().uv(34, 76).cuboid(-3.0F, -3.0F, -5.0F, 6.0F, 20.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, 2.0F, 11.0F));

		ModelPartData r_back2 = r_back.addChild("r_back2", ModelPartBuilder.create().uv(100, 71).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 43.0F, 3.0F, new Dilation(0.0F))
		.uv(97, 0).cuboid(-2.0F, -1.0F, -3.0F, 4.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 17.0F, 0.0F));
		return TexturedModelData.of(modelData, 156, 156);
	}

	@Override
	public void setAngles(SoulWaderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.SOULWADER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.SOULWADER_IDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -20.0f, 20.0f);
		headPitch = MathHelper.clamp(headPitch, -20.0f, 20.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		soul_wader.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return soul_wader;
	}

}