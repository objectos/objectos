/*
 * Copyright (C) 2021-2022 Objectos Software LTDA.
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
package br.com.objectos.logging;

/**
 * Represents an event of a program execution that can be logged. Examples of
 * events that can be modeled by instances of this class are
 *
 * <ul>
 * <li>the application start;</li>
 * <li>the operation to be performed by a class completes abruptly because of
 * exception {@code e}; and</li>
 * <li>the service implemented by a class receives a message with values
 * {@code x} and {@code y}.</li>
 * </ul>
 *
 * <p>
 * This class represents the event specification, not the event instance; a
 * logging message is an invocation of instances of this class. From this, a
 * logging message is (logically) composed of a logging event (instances of this
 * class) and zero or more arguments.
 *
 * <p>
 * As an example, suppose that you want to log the successful GET responses of a
 * HTTP server. The log message should contain the client's IP address, the path
 * name of the resource and the total number of bytes sents. The following could
 * be the event specification
 *
 * <pre>
 * {@code Event3<InetAddress, String, Integer> GET_OK = Events.info(
 *     HttpServer.class, "HTTP_GET_OK", InetAddress.class, String.class, Integer.class
 * );}</pre>
 *
 * <p>
 * While the invocation of this event, i.e., the actual log message would be
 * in the form
 *
 * <pre>
 * logger.log(GET_OK, clientAddress, pathName, bytes.length);</pre>
 *
 * Therefore, an {@code Event} instance indicates:
 *
 * <ul>
 * <li>the {@code source} of a log message. The {@code source} is the class
 * from which a log message originated;</li>
 * <li>the {@code level} of a log message;</li>
 * <li>the {@code key} of the event. The event key is a name that uniquely
 * identifies the event within a {@code source}. It also serves as a description
 * of the event itself; and</li>
 * <li>the number and the types of the arguments that should be supplied to a
 * {@link Logger} instance when invoking this event.</li>
 * </ul>
 */
public abstract class Event {

  private final String key;

  private final Level level;

  private final Class<?> source;

  Event(Class<?> source, String key, Level level) {
    this.key = Checks.checkNotNull(key, "key == null");

    this.level = Checks.checkNotNull(level, "level == null");

    this.source = Checks.checkNotNull(source, "source == null");
  }

  /**
   * <p>
   * Compares the specified object with this event for equality. Returns
   * {@code true} if and only if
   *
   * <ul>
   * <li>the specified object is also a {@code Event};</li>
   * <li>the specified object is of the same subclass of {@code Event};</li>
   * <li>both events have keys that are equal to each other; and</li>
   * <li>both events have source classes that are equal to each other.</li>
   * </ul>
   *
   * @param obj
   *        the object to be compared for equality with this event
   *
   * @return {@code true} if the specified object is equal to this event
   */
  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Event)) {
      return false;
    }

    Event that;
    that = (Event) obj;

    return getClass().equals(that.getClass())
        && key.equals(that.key)
        && source.equals(that.source);
  }

  /**
   * Returns the key of this event.
   *
   * @return the key of this event
   */
  public final String getKey() {
    return key;
  }

  /**
   * Returns the logging level of this event.
   *
   * @return the logging level of this event
   */
  public final Level getLevel() {
    return level;
  }

  /**
   * Returns the source class of this event.
   *
   * @return the source class of this event
   */
  public final Class<?> getSource() {
    return source;
  }

  /**
   * Returns the hash code value of this event.
   *
   * @return the hash code value of this event
   */
  @Override
  public final int hashCode() {
    int result;
    result = 17;

    result = 31 * result + key.hashCode();

    result = 31 * result + source.hashCode();

    return result;
  }

  /**
   * Returns {@code true} if this event would be logged at the specified
   * {@code level}.
   *
   * @param level
   *        the level to check against
   *
   * @return {@code true} if this event would be logged at the specified
   *         {@code level}
   */
  public final boolean isEnabled(Level level) {
    return this.level.compareTo(level) >= 0;
  }

  /**
   * Returns a string representation of this event.
   *
   * @return a string representation of this event
   */
  @Override
  public final String toString() {
    StringBuilder sb = new StringBuilder();

    Class<? extends Event> type;
    type = getClass();

    sb.append(type.getSimpleName());

    sb.append('[');

    sb.append(source.getCanonicalName());

    sb.append(',');

    sb.append(level.name());

    sb.append(',');

    sb.append(key);

    sb.append(']');

    return sb.toString();
  }

}