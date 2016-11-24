package com.github;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {
    @Test
    public void emptyBoardHasNoShip() throws Exception {
        char[][] board = new char[][]{{}};
        int count = new Solution().countBattleships(board);
        assertThat(count, is(0));
    }
}