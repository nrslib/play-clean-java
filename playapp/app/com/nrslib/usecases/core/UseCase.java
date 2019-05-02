package com.nrslib.usecases.core;

public interface UseCase<TInputData extends InputData, TOutputData extends OutputData> {
    TOutputData handle(TInputData inputData);
}
