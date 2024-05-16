package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.custom.GeyserBerryEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class GeyserBerry<T extends GeyserBerryEntity> extends SinglePartEntityModel<T> {
	private final ModelPart geyser_berry;
	public GeyserBerry(ModelPart root) {
		this.geyser_berry = root.getChild("geyser_berry");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData geyser_berry = modelPartData.addChild("geyser_berry", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -10.0F, -2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 4).cuboid(-2.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		geyser_berry.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return geyser_berry;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}