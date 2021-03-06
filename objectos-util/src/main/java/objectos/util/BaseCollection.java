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

import java.util.Collection;
import java.util.function.Predicate;
import objectos.lang.ToString;

/**
 * The base {@link Collection} interface for the Objectos Collections API.
 *
 * <p>
 * Implementations of this interface are required to reject {@code null}
 * elements.
 *
 * @param <E> type of the elements in this collection
 */
interface BaseCollection<E> extends Collection<E>, Joinable, ToString.Formattable {

  /**
   * Adds the specified element to this collection.
   *
   * @param e
   *        an element to be added to this collection
   *
   * @return {@code true} if this collection was modified as a result of this
   *         operation
   *
   * @throws NullPointerException
   *         if the specified element is {@code null}
   */
  @Override
  boolean add(E e);

  /**
   * Adds all of the elements of the specified collection to this collection.
   *
   * @param c
   *        a collection containing the elements to be added to this collection
   *
   * @return {@code true} if this collection was modified as a result of this
   *         operation
   *
   * @throws NullPointerException
   *         if the specified collection is {@code null} or if any of its
   *         element is null
   */
  @Override
  boolean addAll(Collection<? extends E> c);

  /**
   * Returns the only element of this collection or throws an exception if the
   * collection is empty or if the collection contains more than one element.
   *
   * @return the only element of this collection
   *
   * @throws IllegalStateException
   *         if the collection is empty or if the collection contains more than
   *         one element
   */
  E getOnly() throws IllegalStateException;

  /**
   * Returns an unmodifiable iterator over the elements in this collection.
   *
   * @return an unmodifiable iterator over the elements in this collection
   */
  @Override
  UnmodifiableIterator<E> iterator();

  /**
   * This operation is not supported.
   *
   * <p>
   * This method performs no operation other than throw an
   * {@link UnsupportedOperationException}.
   *
   * @param o
   *        ignored (this operation is not supported)
   *
   * @return this method does not return as it always throw an exception
   *
   * @throws UnsupportedOperationException
   *         always
   */
  @Override
  default boolean remove(Object o) {
    throw new UnsupportedOperationException();
  }

  /**
   * This operation is not supported.
   *
   * <p>
   * This method performs no operation other than throw an
   * {@link UnsupportedOperationException}.
   *
   * @param c
   *        ignored (this operation is not supported)
   *
   * @return this method does not return as it always throw an exception
   *
   * @throws UnsupportedOperationException
   *         always
   */
  @Override
  default boolean removeAll(Collection<?> c) {
    throw new UnsupportedOperationException();
  }

  /**
   * This operation is not supported.
   *
   * <p>
   * This method performs no operation other than throw an
   * {@link UnsupportedOperationException}.
   *
   * @param filter
   *        ignored (this operation is not supported)
   *
   * @return this method does not return as it always throw an exception
   *
   * @throws UnsupportedOperationException
   *         always
   */
  @Override
  default boolean removeIf(Predicate<? super E> filter) {
    throw new UnsupportedOperationException();
  }

  /**
   * This operation is not supported.
   *
   * <p>
   * This method performs no operation other than throw an
   * {@link UnsupportedOperationException}.
   *
   * @param c
   *        ignored (this operation is not supported)
   *
   * @return this method does not return as it always throw an exception
   *
   * @throws UnsupportedOperationException
   *         always
   */
  @Override
  default boolean retainAll(Collection<?> c) {
    throw new UnsupportedOperationException();
  }

}