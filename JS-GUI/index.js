const cells = document.querySelectorAll(".cell");
const statusText = document.querySelector("#statusText");
const restartBtn = document.querySelector("#restartBtn");
const winConditions = [
    [0,1,2],
    [3,4,5],
    [6,7,8],
    [0,3,6],
    [1,4,7],
    [2,5,8],
    [0,4,8],
    [2,4,6]
];
let board = ["","","","","","","","",""]
let currentPlayer = "X";
let running = false;

initializeGame();

function initializeGame(){
    running = true;
    cells.forEach(cell => cell.addEventListener("click", cellClicked));
    restartBtn.addEventListener("click",restart);
    statusText.textContent = `Player ${currentPlayer}'s Move`;

}

function cellClicked(){
    const cellIndex = this.getAttribute("cellIndex");
    if(board[cellIndex] != "" || !running){
        return;
    }
    board[cellIndex] = currentPlayer;
    this.textContent = currentPlayer;
    checkWin();
}

function checkWin(){
    let roundWon = false;

    for(let i = 0 ; i<winConditions.length ; i++){
        const conditions = winConditions[i];
        const cellA = board[conditions[0]];
        const cellB = board[conditions[1]];
        const cellC = board[conditions[2]];

        if (cellA == "" || cellB == "" || cellC == ""){
            continue;
        }
        if (cellA == cellB && cellB == cellC){
            roundWon = true;
            break;
        }
    }
    if(roundWon){ //win case
        statusText.textContent = ` ${currentPlayer} Won!`;
        running = false;
    }
    else if(!board.includes("")){ //draw case

        statusText.textContent = "Draw!";

    }
    else{
        changeTurn();
    }
}

function changeTurn(){
    currentPlayer = (currentPlayer == "X") ? "O" : "X";
    statusText.textContent = `Player ${currentPlayer}'s Move`;
}

function restart(){
    board = ["","","","","","","","",""];
    cells.forEach(cell=>cell.textContent = "");
    currentPlayer = "X";
    statusText.textContent = `Player ${currentPlayer}'s Move`;
    running=true;
}


