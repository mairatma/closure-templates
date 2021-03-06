/*
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.template.soy.exprtree;

import junit.framework.TestCase;


/**
 * Unit tests for DataRefNode.
 *
 * @author Kai Huang
 */
public class DataRefNodeTest extends TestCase {


  public void testToSourceString() {

    // Regular data ref.
    DataRefNode drn = new DataRefNode(false, false, "boo");
    drn.addChild(new DataRefAccessIndexNode(false, 0));
    drn.addChild(new DataRefAccessExprNode(false, new StringNode("foo")));
    drn.addChild(new DataRefAccessExprNode(false, new IntegerNode(5)));
    drn.addChild(new DataRefAccessKeyNode(false, "goo"));

    assertEquals("$boo.0['foo'][5].goo", drn.toSourceString());

    // Injected data ref.
    DataRefNode ijDrn = new DataRefNode(true, false, "boo");
    ijDrn.addChildren(drn.getChildren());

    assertEquals("$ij.boo.0['foo'][5].goo", ijDrn.toSourceString());

    // Injected data ref with some null-safe accesses.
    DataRefNode nullSafeIjDrn = new DataRefNode(true, true, "boo");
    nullSafeIjDrn.addChildren(drn.getChildren());
    nullSafeIjDrn.replaceChild(1, new DataRefAccessExprNode(true, new StringNode("foo")));
    nullSafeIjDrn.replaceChild(3, new DataRefAccessKeyNode(true, "goo"));

    assertEquals("$ij?.boo.0?['foo'][5]?.goo", nullSafeIjDrn.toSourceString());
  }

}
