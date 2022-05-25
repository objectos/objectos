/*
 * Copyright (C) 2022 Objectos Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package objectos.lang;

/**
 * Represents a logging level. Levels typically represent the severity of an
 * event. They may be used by loggers to limit which message are actually
 * logged.
 *
 * @since 0.2
 */
public enum Level {

  /**
   * The TRACE level is typically used for events that are for detailed
   * internal workings.
   */
  TRACE(0),

  /**
   * The DEBUG level is typically used for events that are for debugging
   * purposes.
   */
  DEBUG(1),

  /**
   * The INFO level is typically used for events that are informational.
   */
  INFO(2),

  /**
   * The WARN level is typically used for events demanding attention.
   */
  WARN(3),

  /**
   * The ERROR level is typically used for events demanding immediate attention.
   */
  ERROR(4);

  private final byte key;

  private Level(int key) {
    this.key = (byte) key;
  }

  /**
   * Returns a {@code byte} value representing this level's key.
   *
   * @return key value of this level
   */
  public final byte getKey() {
    return key;
  }

}
