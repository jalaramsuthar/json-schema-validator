/*
 * Copyright (c) 2013, Francis Galiegue <fgaliegue@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.fge.jsonschema.library.validator;

import com.github.fge.jsonschema.keyword.equivalence.common.AdditionalPropertiesEquivalence;
import com.github.fge.jsonschema.keyword.equivalence.common.MaximumEquivalence;
import com.github.fge.jsonschema.keyword.equivalence.common.MinimumEquivalence;
import com.github.fge.jsonschema.keyword.validator.common.AdditionalItemsKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.common.AdditionalPropertiesKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.common.MaxItemsKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.common.MaximumKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.common.MinItemsKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.common.MinimumKeywordValidator;
import com.github.fge.jsonschema.keyword.validator.common.UniqueItemKeywordValidator;
import com.github.fge.jsonschema.library.Dictionary;
import com.github.fge.jsonschema.library.DictionaryBuilder;
import com.github.fge.jsonschema.processing.build.KeywordDescriptor;
import com.github.fge.jsonschema.processing.build.KeywordDescriptorBuilder;

import static com.github.fge.jsonschema.util.NodeType.*;

public final class CommonValidatorDictionary
{
    private static final Dictionary<KeywordDescriptor> DICTIONARY;

    private CommonValidatorDictionary()
    {
    }

    public static Dictionary<KeywordDescriptor> get()
    {
        return DICTIONARY;
    }

    static {
        final DictionaryBuilder<KeywordDescriptor> builder
            = Dictionary.newBuilder();

        String keyword;
        KeywordDescriptorBuilder descriptor;

        /*
         * Arrays
         */
        keyword = "additionalItems";
        descriptor = KeywordDescriptor.newBuilder().setValidatedTypes(ARRAY)
            .setValidatorClass(AdditionalItemsKeywordValidator.class);
        builder.addEntry(keyword, descriptor.freeze());

        keyword = "minItems";
        descriptor = KeywordDescriptor.newBuilder().setValidatedTypes(ARRAY)
            .setValidatorClass(MinItemsKeywordValidator.class);
        builder.addEntry(keyword, descriptor.freeze());

        keyword = "maxItems";
        descriptor = KeywordDescriptor.newBuilder().setValidatedTypes(ARRAY)
            .setValidatorClass(MaxItemsKeywordValidator.class);
        builder.addEntry(keyword, descriptor.freeze());

        keyword = "uniqueItems";
        descriptor = KeywordDescriptor.newBuilder().setValidatedTypes(ARRAY)
            .setValidatorClass(UniqueItemKeywordValidator.class);
        builder.addEntry(keyword, descriptor.freeze());

        /*
         * Numbers and integers
         */
        keyword = "minimum";
        descriptor = KeywordDescriptor.newBuilder()
            .setValidatedTypes(INTEGER, NUMBER)
            .setValidatorClass(MinimumKeywordValidator.class)
            .setEquivalence(MinimumEquivalence.getInstance());
        builder.addEntry(keyword, descriptor.freeze());

        keyword = "maximum";
        descriptor = KeywordDescriptor.newBuilder()
            .setValidatedTypes(INTEGER, NUMBER)
            .setValidatorClass(MaximumKeywordValidator.class)
            .setEquivalence(MaximumEquivalence.getInstance());
        builder.addEntry(keyword, descriptor.freeze());

        /*
         * Objects
         */
        keyword = "additionalProperties";
        descriptor = KeywordDescriptor.newBuilder().setValidatedTypes(OBJECT)
            .setValidatorClass(AdditionalPropertiesKeywordValidator.class)
            .setEquivalence(AdditionalPropertiesEquivalence.getInstance());
        builder.addEntry(keyword, descriptor.freeze());

        DICTIONARY = builder.freeze();
    }
}