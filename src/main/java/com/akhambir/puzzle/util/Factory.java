package com.akhambir.puzzle.util;

import com.akhambir.puzzle.driver.GameDriverImpl;
import com.akhambir.puzzle.driver.initializer.GameInitializer;
import com.akhambir.puzzle.driver.interfaces.GameDriver;
import com.akhambir.puzzle.io.CommandLineInputHandler;
import com.akhambir.puzzle.io.interfaces.InputHandler;
import com.akhambir.puzzle.presentation.CommandLineResponseHandler;
import com.akhambir.puzzle.presentation.interfaces.ResponseHandler;
import com.akhambir.puzzle.processor.interfaces.GameProcessor;
import com.akhambir.puzzle.processor.GameProcessorImpl;

import java.util.Scanner;

public final class Factory {

    private Factory() {}


    public static GameDriver getGameDriverIml(InputHandler inputHandler) {
        return new GameDriverImpl(inputHandler);
    }

    public static InputHandler getCommandLineInputHandler(GameProcessor gameProcessor) {
        return new CommandLineInputHandler(gameProcessor, new Scanner(System.in));
    }

    public static GameProcessor getGameProcessorImpl(ResponseHandler responseHandler) {

        GameProcessorImpl gameProcessor = new GameProcessorImpl(responseHandler);
        GameInitializer gameInitializer = new GameInitializer();
        int[] initialGameState = gameInitializer.initialize(getInitialGameState());
        gameProcessor.setInitialGameState(initialGameState);
        return gameProcessor;
    }

    public static int[] getInitialGameState() {
        return new int[] {-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15};
    }

    public static ResponseHandler getCommandLineResponseHandler() {
        return new CommandLineResponseHandler();
    }
}
