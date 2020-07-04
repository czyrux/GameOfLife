import {
    LIVE_CELL,
    DEAD_CELL,
    CELL_STATE_ALIVE,
    CELL_STATE_DEATH
} from "../src/constants";

function countAliveNeighbours(neighbourCells) {
    var aliveNeighbours = 0;
    neighbourCells.forEach(cell => {
        if (cell.state === CELL_STATE_ALIVE) {
            aliveNeighbours++;
        }
    });
    return aliveNeighbours;
}

let underpopulationRule = {
    isApplicable: function(cell, neighbourCells) {
        if (cell.state === CELL_STATE_DEATH) {
            return false;
        }
        return countAliveNeighbours(neighbourCells) < 2;
    },
    newCellState: function() {
        return DEAD_CELL;
    }
};

export { underpopulationRule };
