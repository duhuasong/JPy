package com.andrea.vm;

import com.andrea.pyobjects.PyCodeObject;

/**
 * The important thing to notice is that calling a function --- invoking the __call__ method --- creates a new Frame object and starts running it.
 */
public class Function {
    private VirtualMachine virtualMachine;
    private String name;
    private PyCodeObject codeObject;
    private Object[] defaults;

    public Function(VirtualMachine virtualMachine, String name, PyCodeObject codeObject, Object[] defaults) {
        this.virtualMachine = virtualMachine;
        this.name = name;
        this.codeObject = codeObject;
        this.defaults = defaults;
    }

    public Object call(Object[] args) throws Exception{
        Frame frame = virtualMachine.createFrame(codeObject);
        return virtualMachine.runFrame(frame);
    }
}
