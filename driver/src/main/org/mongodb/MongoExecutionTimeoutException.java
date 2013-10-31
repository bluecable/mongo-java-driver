/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mongodb;

import org.mongodb.connection.ServerAddress;

import static java.lang.String.format;

/**
 * Exception indicating that the execution of the current operation timed outas a result of the maximum operation time being exceeded.
 *
 * @since 3.0
 */
public class MongoExecutionTimeoutException extends MongoServerException {

    private static final long serialVersionUID = -8831703372266982933L;

    private final int errorCode;
    private final String errorMessage;

    public MongoExecutionTimeoutException(final ServerAddress address, final int errorCode, final String errorMessage) {
        super(format("Execution timeout with error code %d and error message '%s' on server %s", errorCode, errorMessage, address),
              address);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
