package engine.process;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Guardian;
import engine.mobile.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
class MobileElementManagerTest {
    Map map = new Map(3,3);
    MobileElementManager manager = new MobileElementManager(map);
    Block block = map.getBlock(1, 1);
    Player player = new Player(block);

    @Test
    @DisplayName("MoveLeftPlayer") //function ajt a mobileelementmanager
    void moveLeftPlayer() {
        Block block2 = map.getBlock(1, 0);
        manager.set(player);
        assertEquals(block2, manager.moveLeftPlayer2());
    }

    @Test
    @DisplayName("MoveRightPlayer")
    void moveRightPlayer() {
        Block block3 = map.getBlock(1, 2);
        manager.set(player);
        assertEquals(block3, manager.moveRightPlayer2());
    }

    @Test
    @DisplayName("MoveUpPlayer")
    void moveUpPlayer() {
        Block block3 = map.getBlock(0, 1);
        manager.set(player);
        assertEquals(block3, manager.moveUpPlayer2());
    }

    @Test
    @DisplayName("MoveDownPlayer")
    void moveDownPlayer() {
        Block block4 = map.getBlock(2, 1);
        manager.set(player);
        assertEquals(block4, manager.moveDownPlayer2());
    }

    @Test
    @DisplayName("Impact")
    void impact() {
        manager.set(player);
        Block blockGUARD = map.getBlock(1, 1);
        Guardian guardian = new Guardian(blockGUARD);
        manager.set(guardian);
        assertEquals("You loose", manager.impact()); // modif fait a impact a voir mobileelementmanager

    }
}