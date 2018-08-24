package fi.dy.masa.litematica.render;

import com.mumfrey.liteloader.util.debug.DebugMessage;
import com.mumfrey.liteloader.util.debug.DebugMessage.Position;
import fi.dy.masa.litematica.world.SchematicWorldHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.text.TextFormatting;

public class DebugScreenMessages
{
    public static final DebugMessage MESSAGE_EMPTY_LINE = DebugMessage.create(Position.LEFT_BOTTOM, "");
    public static final DebugMessage MESSAGE_RENDERER = DebugMessage.create(Position.LEFT_BOTTOM, "");
    public static final DebugMessage MESSAGE_ENTITIES = DebugMessage.create(Position.LEFT_BOTTOM, "");

    public static void update(Minecraft mc)
    {
        if (mc.gameSettings.showDebugInfo)
        {
            RenderGlobal render = LitematicaRenderer.getInstance().getRenderGlobal();
            WorldClient world = SchematicWorldHandler.getSchematicWorld();

            String pre = TextFormatting.GOLD.toString();
            String rst = TextFormatting.RESET.toString();

            MESSAGE_RENDERER.setMessage(String.format("%s[Litematica]%s %s", pre, rst, render.getDebugInfoRenders()));

            String str = String.format("E %s TE: %d", world.getDebugLoadedEntities(), world.loadedTileEntityList.size());
            MESSAGE_ENTITIES.setMessage(String.format("%s[Litematica]%s %s %s", pre, rst, render.getDebugInfoEntities(), str));
        }
    }
}
