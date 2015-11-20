/*
 * Copyright 2015 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.gen5.engine.junit5.testers;

import static org.junit.gen5.commons.util.ReflectionUtils.MethodSortOrder.HierarchyDown;

import java.util.function.Predicate;

import org.junit.gen5.commons.util.ReflectionUtils;

/**
 * @since 5.0
 */
public class IsTestClassWithTests implements Predicate<Class<?>> {

	private static final IsTestMethod isTestMethod = new IsTestMethod();

	private static final IsPotentialTestClass isPotentialTestClass = new IsPotentialTestClass();

	@Override
	public boolean test(Class<?> candidate) {
		return isPotentialTestClass.test(candidate) && hasTestMethods(candidate);
	}

	private boolean hasTestMethods(Class<?> candidate) {
		return !ReflectionUtils.findMethods(candidate, isTestMethod, HierarchyDown).isEmpty();
	}

}
