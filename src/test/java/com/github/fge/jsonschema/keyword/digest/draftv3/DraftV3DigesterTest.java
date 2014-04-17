/*
 * Copyright (c) 2014, Francis Galiegue (fgaliegue@gmail.com)
 *
 * This software is dual-licensed under:
 *
 * - the Lesser General Public License (LGPL) version 3.0 or, at your option, any
 *   later version;
 * - the Apache Software License (ASL) version 2.0.
 *
 * The text of this file and of both licenses is available at the root of this
 * project or, if you have the jar distribution, in directory META-INF/, under
 * the names LGPL-3.0.txt and ASL-2.0.txt respectively.
 *
 * Direct link to the sources:
 *
 * - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
 * - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
 */

package com.github.fge.jsonschema.keyword.digest.draftv3;

import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.keyword.digest.AbstractDigesterTest;
import com.github.fge.jsonschema.library.digest.DraftV3DigesterDictionary;

import java.io.IOException;

public abstract class DraftV3DigesterTest
    extends AbstractDigesterTest
{
    protected DraftV3DigesterTest(final String keyword, final NodeType first,
        final NodeType... other)
        throws IOException
    {
        super(DraftV3DigesterDictionary.get(), "draftv3", keyword, first,
            other);
    }
}