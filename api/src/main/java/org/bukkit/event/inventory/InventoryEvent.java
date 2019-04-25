
package org.bukkit.event.inventory;

import java.util.List;

import org.bukkit.event.HandlerList;
import org.bukkit.World;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

import io.akarin.server.api.event.WorldAttachedEvent;

/**
 * Represents a player related inventory event
 */
public class InventoryEvent extends Event implements WorldAttachedEvent { // Akarin
    private static final HandlerList handlers = new HandlerList();
    protected InventoryView transaction;
    // Akarin start
    @NotNull
    @Override
    public World getWorld() { return transaction.getPlayer().getWorld(); }
    @NotNull
    public HumanEntity getWhoClicked() { return transaction.getPlayer(); }
    // Akarin end

    public InventoryEvent(@NotNull InventoryView transaction) {
        this.transaction = transaction;
    }

    /**
     * Gets the primary Inventory involved in this transaction
     *
     * @return The upper inventory.
     */
    @NotNull
    public Inventory getInventory() {
        return transaction.getTopInventory();
    }

    /**
     * Gets the list of players viewing the primary (upper) inventory involved
     * in this event
     *
     * @return A list of people viewing.
     */
    @NotNull
    public List<HumanEntity> getViewers() {
        return transaction.getTopInventory().getViewers();
    }

    /**
     * Gets the view object itself
     *
     * @return InventoryView
     */
    @NotNull
    public InventoryView getView() {
        return transaction;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
