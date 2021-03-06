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
package objectos.util;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

final class GrowableCollectionGetOnlyTest {

  private final GrowableCollection<Thing> it;

  public GrowableCollectionGetOnlyTest(GrowableCollection<Thing> it) {
    this.it = it;
  }

  public void execute() {
    try {
      it.getOnly();

      Assert.fail();
    } catch (IllegalStateException expected) {
      assertEquals(expected.getMessage(), "Could not getOnly: empty.");
    }

    var t1 = Thing.next();

    it.add(t1);

    assertEquals(it.getOnly(), t1);

    var t2 = Thing.next();

    it.add(t2);

    // standard
    try {
      it.getOnly();

      Assert.fail();
    } catch (IllegalStateException expected) {
      assertEquals(expected.getMessage(), "Could not getOnly: more than one element.");
    }
  }

}