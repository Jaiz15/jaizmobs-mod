package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.jaiz.jaizmobs.entity.custom.EmberBeetleEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class EmberBeetle<T extends EmberBeetleEntity> extends SinglePartEntityModel<T> {
	private final ModelPart emberbeetle;
	private final ModelPart head;

	public EmberBeetle(ModelPart root) {
		this.emberbeetle = root.getChild("emberbeetle");
		this.head = emberbeetle.getChild("base").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData emberbeetle = modelPartData.addChild("emberbeetle", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData base = emberbeetle.addChild("base", ModelPartBuilder.create().uv(0, 4).cuboid(-1.5F, 0.0F, -0.4167F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 4).cuboid(1.5F, 0.0F, -0.4167F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(10, 9).cuboid(-1.5F, 0.0F, -1.9167F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(10, 10).cuboid(1.5F, 0.0F, -1.9167F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.5F, -1.0F, -1.9167F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(12, 2).cuboid(-1.0F, -2.0F, -1.9167F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.9167F));

		ModelPartData head = base.addChild("head", ModelPartBuilder.create().uv(0, 11).cuboid(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.5F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 2).cuboid(0.5F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, -1.9167F));

		ModelPartData shell = base.addChild("shell", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -1.9167F));

		ModelPartData shell_l = shell.addChild("shell_l", ModelPartBuilder.create().uv(8, 7).cuboid(0.0F, -2.0F, 0.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData shell_r = shell.addChild("shell_r", ModelPartBuilder.create().uv(0, 5).cuboid(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData wing_l = shell.addChild("wing_l", ModelPartBuilder.create().uv(6, 0).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

		ModelPartData wing_r = shell.addChild("wing_r", ModelPartBuilder.create().uv(4, 5).cuboid(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));
		return TexturedModelData.of(modelData, 24, 24);
	}

	@Override
	public void setAngles(EmberBeetleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.EMBERBEETLE_FLY, limbSwing, limbSwingAmount, 2f, 2.5f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -10.0f, 10.0f);
		headPitch = MathHelper.clamp(headPitch, -10.0f, 10.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		emberbeetle.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return emberbeetle;
	}

}