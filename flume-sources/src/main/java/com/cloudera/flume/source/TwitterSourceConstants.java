/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cloudera.flume.source;

public class TwitterSourceConstants {

  public static final String CONSUMER_KEY_KEY = "consumerKey";
  public static final String CONSUMER_SECRET_KEY = "consumerSecret";
  public static final String ACCESS_TOKEN_KEY = "accessToken";
  public static final String ACCESS_TOKEN_SECRET_KEY = "accessTokenSecret";
  
  public static final String BATCH_SIZE_KEY = "batchSize";
  public static final long DEFAULT_BATCH_SIZE = 1000L;

  public static final String KEYWORDS_KEY = "keywords";
}
