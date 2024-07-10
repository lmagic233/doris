// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids.trees.expressions.functions.scalar;

import org.apache.doris.catalog.FunctionSignature;
import org.apache.doris.nereids.trees.expressions.Expression;
import org.apache.doris.nereids.trees.expressions.functions.ExplicitlyCastableSignature;
import org.apache.doris.nereids.trees.expressions.functions.PropagateNullable;
import org.apache.doris.nereids.trees.expressions.visitor.ExpressionVisitor;
import org.apache.doris.nereids.types.ArrayType;
import org.apache.doris.nereids.types.BigIntType;
import org.apache.doris.nereids.types.BooleanType;
import org.apache.doris.nereids.types.DateTimeType;
import org.apache.doris.nereids.types.DateType;
import org.apache.doris.nereids.types.DecimalV2Type;
import org.apache.doris.nereids.types.DecimalV3Type;
import org.apache.doris.nereids.types.DoubleType;
import org.apache.doris.nereids.types.FloatType;
import org.apache.doris.nereids.types.IntegerType;
import org.apache.doris.nereids.types.LargeIntType;
import org.apache.doris.nereids.types.SmallIntType;
import org.apache.doris.nereids.types.StringType;
import org.apache.doris.nereids.types.TinyIntType;
import org.apache.doris.nereids.types.VarcharType;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * ScalarFunction '%element_slice%'. This class is generated by GenerateFunction.
 */
public class ElementSlice extends ScalarFunction
        implements ExplicitlyCastableSignature, PropagateNullable {

    public static final List<FunctionSignature> SIGNATURES = ImmutableList.of(
            FunctionSignature.ret(ArrayType.of(BooleanType.INSTANCE))
                    .args(ArrayType.of(BooleanType.INSTANCE), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(TinyIntType.INSTANCE))
                    .args(ArrayType.of(TinyIntType.INSTANCE), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(SmallIntType.INSTANCE))
                    .args(ArrayType.of(SmallIntType.INSTANCE), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(IntegerType.INSTANCE))
                    .args(ArrayType.of(IntegerType.INSTANCE), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(BigIntType.INSTANCE))
                    .args(ArrayType.of(BigIntType.INSTANCE), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(LargeIntType.INSTANCE))
                    .args(ArrayType.of(LargeIntType.INSTANCE), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DateTimeType.INSTANCE))
                    .args(ArrayType.of(DateTimeType.INSTANCE), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DateType.INSTANCE))
                    .args(ArrayType.of(DateType.INSTANCE), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(FloatType.INSTANCE))
                    .args(ArrayType.of(FloatType.INSTANCE), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DoubleType.INSTANCE))
                    .args(ArrayType.of(DoubleType.INSTANCE), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DecimalV2Type.SYSTEM_DEFAULT))
                    .args(ArrayType.of(DecimalV2Type.SYSTEM_DEFAULT), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DecimalV3Type.WILDCARD))
                    .args(ArrayType.of(DecimalV3Type.WILDCARD), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(VarcharType.SYSTEM_DEFAULT))
                    .args(ArrayType.of(VarcharType.SYSTEM_DEFAULT), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(StringType.INSTANCE))
                    .args(ArrayType.of(StringType.INSTANCE), BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(BooleanType.INSTANCE))
                    .args(ArrayType.of(BooleanType.INSTANCE), BigIntType.INSTANCE, BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(TinyIntType.INSTANCE))
                    .args(ArrayType.of(TinyIntType.INSTANCE), BigIntType.INSTANCE, BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(SmallIntType.INSTANCE))
                    .args(ArrayType.of(SmallIntType.INSTANCE), BigIntType.INSTANCE, BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(IntegerType.INSTANCE))
                    .args(ArrayType.of(IntegerType.INSTANCE), BigIntType.INSTANCE, BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(BigIntType.INSTANCE))
                    .args(ArrayType.of(BigIntType.INSTANCE), BigIntType.INSTANCE, BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(LargeIntType.INSTANCE))
                    .args(ArrayType.of(LargeIntType.INSTANCE), BigIntType.INSTANCE, BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DateTimeType.INSTANCE))
                    .args(ArrayType.of(DateTimeType.INSTANCE), BigIntType.INSTANCE, BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DateType.INSTANCE))
                    .args(ArrayType.of(DateType.INSTANCE), BigIntType.INSTANCE, BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(FloatType.INSTANCE))
                    .args(ArrayType.of(FloatType.INSTANCE), BigIntType.INSTANCE, BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DoubleType.INSTANCE))
                    .args(ArrayType.of(DoubleType.INSTANCE), BigIntType.INSTANCE, BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DecimalV2Type.SYSTEM_DEFAULT))
                    .args(ArrayType.of(DecimalV2Type.SYSTEM_DEFAULT), BigIntType.INSTANCE, BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DecimalV3Type.WILDCARD))
                    .args(ArrayType.of(DecimalV3Type.WILDCARD), BigIntType.INSTANCE, BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(VarcharType.SYSTEM_DEFAULT))
                    .args(ArrayType.of(VarcharType.SYSTEM_DEFAULT), BigIntType.INSTANCE, BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(StringType.INSTANCE))
                    .args(ArrayType.of(StringType.INSTANCE), BigIntType.INSTANCE, BigIntType.INSTANCE)
    );

    /**
     * constructor with 2 arguments.
     */
    public ElementSlice(Expression arg0, Expression arg1) {
        super("%element_slice%", arg0, arg1);
    }

    /**
     * constructor with 3 arguments.
     */
    public ElementSlice(Expression arg0, Expression arg1, Expression arg2) {
        super("%element_slice%", arg0, arg1, arg2);
    }

    /**
     * withChildren.
     */
    @Override
    public ElementSlice withChildren(List<Expression> children) {
        Preconditions.checkArgument(children.size() == 2
                || children.size() == 3);
        if (children.size() == 2) {
            return new ElementSlice(children.get(0), children.get(1));
        } else {
            return new ElementSlice(children.get(0), children.get(1), children.get(2));
        }
    }

    @Override
    public <R, C> R accept(ExpressionVisitor<R, C> visitor, C context) {
        return visitor.visitElementSlice(this, context);
    }

    @Override
    public List<FunctionSignature> getSignatures() {
        return SIGNATURES;
    }
}