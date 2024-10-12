###

README.md

# UndoRedoManager

## Description

The `UndoRedoManager` class provides a simple implementation of undo and redo functionality using a doubly linked list. Each state change is stored as a node in the list, allowing for easy navigation between states.

## Features

- **Undo Operation**: Reverts the current state to the previous state.
- **Redo Operation**: Reapplies the last undone state.
- **Add State**: Adds a new state to the sequence.

## Usage

### Adding States

You can add states to the `UndoRedoManager` using the `addState` method.

```java
UndoRedoManager<String> undoRedoManager = new UndoRedoManager<>();
undoRedoManager.addState("State 1");
undoRedoManager.addState("State 2");
undoRedoManager.addState("State 3");
```

### Undo Operation

To undo the last state change, use the `undo` method.

```java
undoRedoManager.undo();
```

### Redo Operation

To redo the last undone state, use the `redo` method.

```java
undoRedoManager.redo();
```

### Example

```java
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
```

## Author

Steve Sharpe

```

```
