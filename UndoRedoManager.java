import java.util.Stack;

public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;

        private Node(T state) {
            this.state = state;
        }
    }

    private Node currentState;
    private Stack<Node> redoStack = new Stack<>();

    // Undo operation
    public T undo() {
        if (currentState == null) {
            System.out.println("No state to undo");
            return null;
        }
        // Get the previous state
        Node previousState = currentState.prev;
        if (previousState == null) {
            System.out.println("Reached the initial state");
            return null;
        } else {
            // Push the current state onto the redo stack
            redoStack.push(currentState);
            // Update the current state to the previous state
            currentState = previousState;
        }
        return currentState.state;
    }

    // Perform an operation
    public void addState(T newState) {
        // Create a new node for the new task
        Node newNode = new Node(newState);

        // Set the links for the new Node
        newNode.prev = currentState;
        newNode.next = null;

        // Update the next link for the current state
        if (currentState != null) {
            currentState.next = newNode;
        }
        // Update the current to the new state
        currentState = newNode;

        // Clear the redo stack since we have a new state
        redoStack.clear();
    }

    // Redo operation
    public T redo() {
        if (redoStack.isEmpty()) {
            System.out.println("No redo available");
            return null;
        }
        // Pop the state from the redo stack and set it as the current state
        Node nextState = redoStack.pop();
        currentState = nextState;
        return currentState.state;
    }

    public static void main(String[] args) {
        UndoRedoManager<String> undoRedoManager = new UndoRedoManager<>();
        undoRedoManager.addState("State 1");
        undoRedoManager.addState("State 2");
        undoRedoManager.addState("State 3");
        undoRedoManager.addState("State 4");
        undoRedoManager.addState("State 5");
        undoRedoManager.addState("State 6");
        undoRedoManager.addState("State 7");

        // Print the current state
        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);

        // Adding redo operations
        undoRedoManager.redo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
    }
}

        