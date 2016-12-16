/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.Knight;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class BraveKnightTest {
    
    @Test
    public void knightShouldEmbarkOnQuest() {
	
	Quest mockQuest = mock(Quest.class); // Create mock Quest
	BraveKnight knight = new BraveKnight(mockQuest); // Inject mock Quest
	knight.embarkOnQuest();
	verify(mockQuest, times(1)).embark();
    }
}
