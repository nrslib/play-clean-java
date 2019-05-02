package com.nrslib.clArc.invoke;

import com.nrslib.usecases.core.InputData;
import com.nrslib.usecases.core.OutputData;

public interface UseCaseInvoker {
    public <TOutputData extends OutputData> TOutputData invoke(InputData<TOutputData> inputData);
}
