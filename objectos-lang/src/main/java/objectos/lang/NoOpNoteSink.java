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
 * A no-op {@code NoteSink} implementation (for the most part). The one
 * exception
 * is the {@link NoteSink#replace(NoteSink)} operation that actually returns the
 * supplied value.
 *
 * @since 0.2
 */
public class NoOpNoteSink implements NoteSink {

  static final NoOpNoteSink INSTANCE = new NoOpNoteSink();

  /**
   * The sole {@code public} constructor.
   */
  public NoOpNoteSink() {}

  /**
   * Returns the {@code static} instance. This is method is provided as a
   * convenience and to avoid creating multiple instances of this instance.
   *
   * @return the {@code static} instance
   */
  public static NoOpNoteSink getInstance() {
    return INSTANCE;
  }

  /**
   * Returns {@code false}.
   *
   * @param event
   *        an event instance (ignored)
   *
   * @return {@code false}
   */
  @Override
  public boolean isEnabled(Note event) {
    return false;
  }

  /**
   * Does nothing, this is a no-op sink.
   *
   * @param event
   *        an event instance (ignored)
   */
  @Override
  public void log(Note0 event) {
    // noop
  }

  /**
   * Does nothing, this is a no-op sink.
   *
   * @param event
   *        an event instance (ignored)
   * @param v1
   *        a value (ignored)
   */
  @Override
  public <T1> void log(Note1<T1> event, T1 v1) {
    // noop
  }

  /**
   * Does nothing, this is a no-op sink.
   *
   * @param event
   *        an event instance (ignored)
   * @param v1
   *        a first value (ignored)
   * @param v2
   *        a second value (ignored)
   */
  @Override
  public <T1, T2> void log(Note2<T1, T2> event, T1 v1, T2 v2) {
    // noop
  }

  /**
   * Does nothing, this is a no-op sink.
   *
   * @param event
   *        an event instance (ignored)
   * @param v1
   *        a first value (ignored)
   * @param v2
   *        a second value (ignored)
   * @param v3
   *        a third value (ignored)
   */
  @Override
  public <T1, T2, T3> void log(Note3<T1, T2, T3> event, T1 v1, T2 v2, T3 v3) {
    // noop
  }

  /**
   * Returns the given {@code sink} value.
   *
   * @param sink
   *        a {@code NoteSink} instance
   *
   * @return the given {@code sink} value
   */
  @Override
  public final NoteSink replace(NoteSink sink) {
    Check.notNull(sink, "sink == null");

    return sink;
  }

}