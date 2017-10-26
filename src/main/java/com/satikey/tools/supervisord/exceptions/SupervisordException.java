package com.satikey.tools.supervisord.exceptions;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public abstract class SupervisordException extends Exception {

    private Code code;

    public SupervisordException(Code code) {
        this.code = code;
    }

    public static SupervisordException create(Code code) {

        switch (code) {
            case UNKNOWN_METHOD:
                return new UnknownMethodException();
            case ALREADY_STARTED:
                return new AlreadyStartedException();
            case NOT_RUNNING:
                return new NotRunningException();
            default:
                throw new IllegalArgumentException("Invalid exception code");
        }
    }

    public static class UnknownMethodException extends SupervisordException {
        public UnknownMethodException(){
            super(Code.UNKNOWN_METHOD);
        }
    }
    public static class AlreadyStartedException extends SupervisordException {
        public AlreadyStartedException() {
            super(Code.ALREADY_STARTED);
        }
    }

    public static class NotRunningException extends SupervisordException {
        public NotRunningException() {
            super(Code.NOT_RUNNING);
        }
    }

    public static enum Code {

        /**
         * Returned on a start request for a process that is already started
         */
        UNKNOWN_METHOD(1),
        ALREADY_STARTED(60),
        NOT_RUNNING(70);

        private static final Map<Integer, Code> lookup
                = new HashMap<Integer, Code>();

        static {
            for (Code c : EnumSet.allOf(Code.class))
                lookup.put(c.code, c);
        }

        private final int code;

        Code(int code) {
            this.code = code;
        }

        /**
         * Get the int value for a particular Code.
         *
         * @return error code as integer
         */
        public int intValue() {
            return code;
        }

        /**
         * Get the Code value for a particular integer error code
         *
         * @param code int error code
         * @return Code value corresponding to specified int code, or null
         */
        public static Code get(int code) {
            return lookup.get(code);
        }
    }

}