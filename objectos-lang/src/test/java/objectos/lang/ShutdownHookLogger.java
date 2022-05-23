/*
 * Copyright (C) 2022-2022 Objectos Software LTDA.
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

import java.util.ArrayList;
import java.util.List;

class ShutdownHookLogger extends NoOpLogger {

  final List<Exception> exceptions = new ArrayList<Exception>();

  @Override
  public final <T> void log(Event1<T> event, T value) {
    if (value instanceof Exception) {
      Exception e;
      e = (Exception) value;

      exceptions.add(e);
    }
  }

}