// This class contains the code in the run() method to solve the maze
// It searches for the Java logo based on the provided path/direction algorithm in Part II
// Authors: Arjit Gupta, Anil Saini
// Date: 2/15/2023

public class Direction extends Thread{

	Maze maze;
	Position location;

	Direction(Maze maze, Position location) {

		this.maze = maze;
		this.location = location;
	}

	@Override
	public void run(){


		location.textArea.append("Currently at row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");

		//Loop to check if java Logo is reached and keep continuing until not reached
		while(!maze.isDone()) {

			//Logic to travel on even columns
			if(maze.getCurrCol() % 2 == 0) {

				if(maze.moveDown()) {
					if(maze.isDone()) {
						break;
					}
					location.textArea.append("Successfully moved down At row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
					continue;
				}
				//last row reached boundary checker code
				else if(maze.getCurrRow() == this.maze.getHeight()-1) {

					//					if(maze.moveDown()) {
					//						location.textArea.append("Successfully moved down| At row: " + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
					//						continue;
					//					}
					//					else {
					location.textArea.append("Failed to move down further. Now at last row: " + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
					if(maze.moveRight()) {
						location.textArea.append("Successfully moved right at row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						continue;
					}
					else {
						location.textArea.append("Failed to move right at row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						if(maze.moveUp()) {
							location.textArea.append("Successfully moved up at row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						}
						else {
							location.textArea.append("Failed to move up at row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						}

						if(maze.isDone()) {
							break;
						}
					}
					//					}
				}
				else {
					// Code that runs when obstacle is encountered
					location.textArea.append("Obstacle reached.\n");
					if(maze.moveRight()) {
						location.textArea.append("Successfully moved Right at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
						if(maze.isDone()) {
							break;
						}
					} else {
						location.textArea.append("Failed to move Right at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
					}


					if(maze.moveDown()) {
						location.textArea.append("Successfully moved Down at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
						if(maze.isDone()) {
							break;
						}
					} else {
						location.textArea.append("Failed to move down at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
					}

					if(maze.moveDown()) {
						location.textArea.append("Successfully moved Down at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
						if(maze.isDone()) {
							break;
						}
					} else {
						location.textArea.append("Failed to move down at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
					}

					if(maze.moveLeft()) {
						location.textArea.append("Successfully moved Left at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
						if(maze.isDone()) {
							break;
						}
					} else {
						location.textArea.append("Failed to move Left at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
					}

					continue;
				}
			}

			//Logic to travel on odd columns
			else {

				//row boundary checker
				if(maze.getCurrRow() == 0) {
					if(!maze.moveUp()) {
						location.textArea.append("Failed to move up at Row: " + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
						maze.moveRight();
						if(maze.isDone()) {
							break;
						}
						location.textArea.append("Succesfully moved right at Row: " + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
						continue;
					}
				}

				if(maze.moveUp()) {
					if(maze.isDone()) {
						break;
					}
					location.textArea.append("Successfully moved up to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
					continue;
				}
				else {
					//Code that runs when obstacle is encountered in odd columns
					location.textArea.append("Obstacle reached.\n");
					if(maze.moveLeft()) {
						location.textArea.append("Succesfully moved Left at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
						if(maze.isDone()) {
							break;
						}
					} else {
						location.textArea.append("Failed to move Left at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
					}


					if(maze.moveUp()) {
						location.textArea.append("Succesfully moved Up at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
						if(maze.isDone()) {
							break;
						}
					} else {
						location.textArea.append("Failed to move Up at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
					}

					if(maze.moveUp()) {
						location.textArea.append("Succesfully moved Up at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
						if(maze.isDone()) {
							break;
						}
					} else {
						location.textArea.append("Failed to move Up at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
					}


					if(maze.moveRight()) {
						location.textArea.append("Succesfully moved Right at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
						if(maze.isDone()) {
							break;
						}
					} else {
						location.textArea.append("Failed to move Right at row:" + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
					}

					continue;
				}
			}


			//			if(this.maze.moveRight()) {
			//				location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			//				location.textArea.append("Success" + "\n");
			//				continue;
			//			}
			//			else {
			//				location.textArea.append("Failure" + "\n");
			//			}
			//
			//			if(this.maze.moveDown()) {
			//				location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			//				location.textArea.append("Success" + "\n");
			//				continue;
			//			}
			//			else {
			//				location.textArea.append("Failure" + "\n");
			//			}
			//
			//			if(this.maze.moveLeft()) {
			//				location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			//				location.textArea.append("Success" + "\n");
			//				continue;
			//			}
			//			else {
			//				location.textArea.append("Failure" + "\n");
			//			}
			//
			//			if(this.maze.moveUp()) {
			//				location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			//				location.textArea.append("Success" + "\n");
			//				continue;
			//			}
			//			else {
			//				location.textArea.append("Failure" + "\n");
			//			}

		}

		location.textArea.append("Logo Found at  row: "+ maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");

	}


}
