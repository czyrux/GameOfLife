import {
    underpopulationRule,
    overcrowdingRule,
    stayAliveRule
} from "../src/rules.js";

import {
    LIVE_CELL,
    DEAD_CELL,
    CELL_STATE_ALIVE,
    CELL_STATE_DEATH
} from "../src/constants";

////////////////////
// Underpopulation Rule
////////////////////

test("Underpopulation apply when Live cell & fewer than two lives neighbours", () => {
    expect(
        underpopulationRule.isApplicable(LIVE_CELL, [
            LIVE_CELL,
            DEAD_CELL,
            DEAD_CELL
        ])
    ).toBeTruthy();
    expect(
        underpopulationRule.isApplicable(LIVE_CELL, [DEAD_CELL, DEAD_CELL])
    ).toBeTruthy();
});

test("Underpopulation NOT apply on dead cells", () => {
    expect(underpopulationRule.isApplicable(DEAD_CELL, [])).toBeFalsy();
});

test("Underpopulation NOT apply when Live cell & more than two live neighbours", () => {
    expect(
        underpopulationRule.isApplicable(LIVE_CELL, [
            LIVE_CELL,
            LIVE_CELL,
            LIVE_CELL,
            DEAD_CELL
        ])
    ).toBeFalsy();
});

test("Cell state when underpopulation applicable is Death", () => {
    expect(underpopulationRule.newCellState().state).toBe(CELL_STATE_DEATH);
});

////////////////////
// Overcrowding Rule
////////////////////

test("Overcrowding NOT apply on death cells", () => {
    expect(overcrowdingRule.isApplicable(DEAD_CELL, [])).toBeFalsy();
});

test("Uvercrowding apply when Live cell & more than 3 live neighbours", () => {
    expect(
        overcrowdingRule.isApplicable(LIVE_CELL, [
            LIVE_CELL,
            LIVE_CELL,
            LIVE_CELL,
            LIVE_CELL,
            DEAD_CELL
        ])
    ).toBeTruthy();
});

test("Uvercrowding NOT apply when Live cell & 3 or less live neighbours", () => {
    expect(
        overcrowdingRule.isApplicable(LIVE_CELL, [
            LIVE_CELL,
            LIVE_CELL,
            LIVE_CELL,
            DEAD_CELL,
            DEAD_CELL
        ])
    ).toBeFalsy();

    expect(
        overcrowdingRule.isApplicable(LIVE_CELL, [
            LIVE_CELL,
            DEAD_CELL,
            DEAD_CELL
        ])
    ).toBeFalsy();
});

////////////////////
// Stay Alive Rule
////////////////////

test("StayAlive NOT apply on death cells", () => {
    expect(stayAliveRule.isApplicable(DEAD_CELL, [])).toBeFalsy();
});

test("Stay Alive apply when Live cell & 2 live neighbours", () => {
    expect(
        stayAliveRule.isApplicable(LIVE_CELL, [
            LIVE_CELL,
            LIVE_CELL,
            DEAD_CELL,
            DEAD_CELL
        ])
    ).toBeTruthy();
});

test("Stay Alive apply when Live cell & 3 live neighbours", () => {
    expect(
        stayAliveRule.isApplicable(LIVE_CELL, [
            LIVE_CELL,
            LIVE_CELL,
            LIVE_CELL,
            DEAD_CELL
        ])
    ).toBeTruthy();
});

test("Stay Alive NOT apply when Live cell & 1 live neighbours", () => {
    expect(
        stayAliveRule.isApplicable(LIVE_CELL, [LIVE_CELL, DEAD_CELL])
    ).toBeFalsy();
});
