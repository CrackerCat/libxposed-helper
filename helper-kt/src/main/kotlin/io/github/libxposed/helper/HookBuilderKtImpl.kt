@file:Suppress("OverridingDeprecatedMember")

package io.github.libxposed.helper

import dalvik.system.BaseDexClassLoader
import io.github.libxposed.XposedInterface
import java.lang.reflect.Member
import java.lang.reflect.Constructor as ReflectConstructor
import java.lang.reflect.Field as ReflectField
import java.lang.reflect.Method as ReflectMethod
import java.lang.Class as ReflectClass
import kotlin.String as KtString

val wo: Nothing
    inline get() = throw UnsupportedOperationException("Write-only property")

abstract class BaseMatcherKtImpl<Base, Match, Impl>
    (
    protected val impl: Impl
) : HookBuilderKt.BaseMatcherKt<Match> where Impl : HookBuilder.BaseMatcher<Impl, Base>, Match : HookBuilderKt.BaseMatchKt<Match, *>, Base : HookBuilder.BaseMatch<Base, *> {
    final override var matchFirst: Boolean
        get() = wo
        set(value) {
            impl.setMatchFirst(value)
        }
}

abstract class ReflectMatcherKtImpl<Base, Match, Impl>(
    impl: Impl
) : BaseMatcherKtImpl<Base, Match, Impl>(impl),
    HookBuilderKt.ReflectMatcherKt<Match> where Impl : HookBuilder.ReflectMatcher<Impl, Base>, Match : HookBuilderKt.ReflectMatchKt<Match, *>, Base : HookBuilder.ReflectMatch<Base, *> {
    final override var key: kotlin.String
        get() = wo
        set(value) {
            impl.setKey(value)
        }
    final override var isPublic: Boolean
        get() = wo
        set(value) {
            impl.setIsPublic(value)
        }
    final override var isPrivate: Boolean
        get() = wo
        set(value) {
            impl.setIsPrivate(value)
        }
    final override var isProtected: Boolean
        get() = wo
        set(value) {
            impl.setIsProtected(value)
        }
    final override var isPackage: Boolean
        get() = wo
        set(value) {
            impl.setIsPackage(value)
        }
}

class ClassMatcherKtImpl(impl: HookBuilder.ClassMatcher) :
    BaseMatcherKtImpl<HookBuilder.Class, HookBuilderKt.ClassKt, HookBuilder.ClassMatcher>(
        impl
    ), HookBuilderKt.ClassMatcherKt {
    override var name: HookBuilderKt.StringKt
        get() = wo
        set(value) {
            impl.setName((value as StringKtImpl).impl)
        }
    override var superClass: HookBuilderKt.ClassKt
        get() = wo
        set(value) {
            impl.setSuperClass((value as ClassKtImpl).impl)
        }
    override val containsMethods: HookBuilderKt.ContainerSyntaxKt<HookBuilderKt.MethodKt>
        get() = wo
    override val containsConstructors: HookBuilderKt.ContainerSyntaxKt<HookBuilderKt.ConstructorKt>
        get() = wo
    override val containsFields: HookBuilderKt.ContainerSyntaxKt<HookBuilderKt.FieldKt>
        get() = wo
    override val interfaces: HookBuilderKt.ContainerSyntaxKt<HookBuilderKt.ClassKt>
        get() = wo
    override var isAbstract: Boolean
        get() = wo
        set(value) {
            impl.setIsAbstract(value)
        }
    override var isStatic: Boolean
        get() = wo
        set(value) {
            impl.setIsStatic(value)
        }
    override var isFinal: Boolean
        get() = wo
        set(value) {
            impl.setIsFinal(value)
        }
    override var key: kotlin.String
        get() = wo
        set(value) {
            impl.setKey(value)
        }
    override var isPublic: Boolean
        get() = wo
        set(value) {
            impl.setIsPublic(value)
        }
    override var isPrivate: Boolean
        get() = wo
        set(value) {
            impl.setIsPrivate(value)
        }
    override var isProtected: Boolean
        get() = wo
        set(value) {
            impl.setIsProtected(value)
        }
    override var isPackage: Boolean
        get() = wo
        set(value) {
            impl.setIsPackage(value)
        }
    override var missReplacement: HookBuilderKt.ClassKt
        get() = wo
        set(value) {
            impl.setMissReplacement((value as ClassKtImpl).impl)
        }
}

class StringMatcherKtImpl(private val impl: HookBuilder.StringMatcher) :
    HookBuilderKt.StringMatcherKt {
    override var exact: KtString
        get() = wo
        set(value) {
            impl.setExact(value)
        }
    override var prefix: KtString
        get() = wo
        set(value) {
            impl.setPrefix(value)
        }
    override var matchFirst: Boolean
        get() = wo
        set(value) {
            impl.setMatchFirst(value)
        }
    override var missReplacement: HookBuilderKt.StringKt
        get() = wo
        set(value) {
            impl.setMissReplacement((value as StringKtImpl).impl)
        }
}

abstract class MemberMatcherKtImpl<Base, Match, Impl>(
    impl: Impl
) : ReflectMatcherKtImpl<Base, Match, Impl>(impl),
    HookBuilderKt.MemberMatcherKt<Match> where Impl : HookBuilder.MemberMatcher<Impl, Base>, Match : HookBuilderKt.MemberMatchKt<Match, *>, Base : HookBuilder.MemberMatch<Base, *> {
    final override var declaringClass: HookBuilderKt.ClassKt
        get() = wo
        set(value) {
            impl.setDeclaringClass((value as ClassKtImpl).impl)
        }
    final override var isSynthetic: Boolean
        get() = wo
        set(value) {
            impl.setIsSynthetic(value)
        }
}

class FieldMatcherKtImpl(impl: HookBuilder.FieldMatcher) :
    MemberMatcherKtImpl<HookBuilder.Field, HookBuilderKt.FieldKt, HookBuilder.FieldMatcher>(
        impl
    ), HookBuilderKt.FieldMatcherKt {
    override var name: HookBuilderKt.StringKt
        get() = wo
        set(value) {
            impl.setName((value as StringKtImpl).impl)
        }
    override var type: HookBuilderKt.ClassKt
        get() = wo
        set(value) {
            impl.setType((value as ClassKtImpl).impl)
        }
    override var isStatic: Boolean
        get() = wo
        set(value) {
            impl.setIsStatic(value)
        }
    override var isFinal: Boolean
        get() = wo
        set(value) {
            impl.setIsFinal(value)
        }
    override var isTransient: Boolean
        get() = wo
        set(value) {
            impl.setIsTransient(value)
        }
    override var isVolatile: Boolean
        get() = wo
        set(value) {
            impl.setIsVolatile(value)
        }
    override var missReplacement: HookBuilderKt.FieldKt
        get() = wo
        set(value) {
            impl.setMissReplacement((value as FieldKtImpl).impl)
        }
}

abstract class ExecutableMatcherKtImpl<Base, Match, Impl>(
    impl: Impl
) : MemberMatcherKtImpl<Base, Match, Impl>(impl),
    HookBuilderKt.ExecutableMatcherKt<Match> where Impl : HookBuilder.ExecutableMatcher<Impl, Base>, Match : HookBuilderKt.ExecutableMatchKt<Match, *>, Base : HookBuilder.ExecutableMatch<Base, *> {
    final override var parameterCounts: Int
        get() = wo
        set(value) {
            impl.setParameterCount(value)
        }
    final override val parameterTypes: HookBuilderKt.ContainerSyntaxKt<IndexedValue<HookBuilderKt.ClassKt>>
        get() = wo

    @HookBuilderKt.DexAnalysis
    final override val referredStrings: HookBuilderKt.ContainerSyntaxKt<HookBuilderKt.StringKt>
        get() = wo

    @HookBuilderKt.DexAnalysis
    final override val assignedFields: HookBuilderKt.ContainerSyntaxKt<HookBuilderKt.FieldKt>
        get() = wo

    @HookBuilderKt.DexAnalysis
    final override val invokedMethods: HookBuilderKt.ContainerSyntaxKt<HookBuilderKt.MethodKt>
        get() = wo

    @HookBuilderKt.DexAnalysis
    final override val invokedConstructor: HookBuilderKt.ContainerSyntaxKt<HookBuilderKt.ConstructorKt>
        get() = wo

    @HookBuilderKt.DexAnalysis
    final override var containsOpcodes: Array<Byte>
        get() = wo
        set(value) {
            impl.setContainsOpcodes(value)
        }
    final override var isVarargs: Boolean
        get() = wo
        set(value) {
            impl.setIsVarargs(value)
        }
}

class MethodMatcherKtImpl(impl: HookBuilder.MethodMatcher) :
    ExecutableMatcherKtImpl<HookBuilder.Method, HookBuilderKt.MethodKt, HookBuilder.MethodMatcher>(
        impl
    ), HookBuilderKt.MethodMatcherKt {
    override var name: HookBuilderKt.StringKt
        get() = wo
        set(value) {
            impl.setName((value as StringKtImpl).impl)
        }
    override var returnType: HookBuilderKt.ClassKt
        get() = wo
        set(value) {
            impl.setReturnType((value as ClassKtImpl).impl)
        }
    override var isAbstract: Boolean
        get() = wo
        set(value) {
            impl.setIsAbstract(value)
        }
    override var isStatic: Boolean
        get() = wo
        set(value) {
            impl.setIsStatic(value)
        }
    override var isFinal: Boolean
        get() = wo
        set(value) {
            impl.setIsFinal(value)
        }
    override var isSynchronized: Boolean
        get() = wo
        set(value) {
            impl.setIsSynchronized(value)
        }
    override var isNative: Boolean
        get() = wo
        set(value) {
            impl.setIsNative(value)
        }
    override var missReplacement: HookBuilderKt.MethodKt
        get() = wo
        set(value) {
            impl.setMissReplacement((value as MethodKtImpl).impl)
        }
}

class ConstructorMatcherKtImpl(impl: HookBuilder.ConstructorMatcher) :
    ExecutableMatcherKtImpl<HookBuilder.Constructor, HookBuilderKt.ConstructorKt, HookBuilder.ConstructorMatcher>(
        impl
    ), HookBuilderKt.ConstructorMatcherKt {
    override var missReplacement: HookBuilderKt.ConstructorKt
        get() = wo
        set(value) {
            impl.setMissReplacement((value as ConstructorKtImpl).impl)
        }
}

object DummyHookerImpl : HookBuilderKt.DummyHooker

abstract class BaseMatchKtImpl<Base, Reflect, Impl>(
    val impl: Impl
) : HookBuilderKt.BaseMatchKt<Base, Reflect> where Impl : HookBuilder.BaseMatch<Impl, Reflect>

abstract class ReflectMatchKtImpl<Base, Reflect, Impl>(
    impl: Impl
) : BaseMatchKtImpl<Base, Reflect, Impl>(impl),
    HookBuilderKt.ReflectMatchKt<Base, Reflect> where Impl : HookBuilder.ReflectMatch<Impl, Reflect> {
    final override val key: KtString?
        get() = impl.key

    final override fun onMatch(handler: HookBuilderKt.DummyHooker.(Reflect) -> Unit): Base =
        newImpl(impl.onMatch {
            DummyHookerImpl.handler(it)
        })

    abstract fun newImpl(impl: Impl): Base

    final override fun div(match: Base): HookBuilderKt.ContainerSyntaxKt<Base> {
        TODO("not yet implemented")
    }

    final override fun times(match: Base): HookBuilderKt.ContainerSyntaxKt<Base> {
        TODO("not yet implemented")
    }

    final override fun minus(match: Base): HookBuilderKt.ContainerSyntaxKt<Base> {
        TODO("not yet implemented")
    }

    final override fun plus(match: Base): HookBuilderKt.ContainerSyntaxKt<Base> {
        TODO("not yet implemented")
    }
}

abstract class LazySequenceKtImpl<Match, Reflect : Any, Matcher, MatchBase, MatcherBase>(
    private val impl: HookBuilder.LazySequence<MatchBase, Reflect, MatcherBase>
) : HookBuilderKt.LazySequenceKt<Match, Reflect, Matcher> where Match : HookBuilderKt.BaseMatchKt<Match, Reflect>, Matcher : HookBuilderKt.BaseMatcherKt<Match>, MatchBase : HookBuilder.BaseMatch<MatchBase, Reflect>, MatcherBase : HookBuilder.BaseMatcher<MatcherBase, MatchBase> {
    override fun first(): Match = newImpl(impl.first())

    override fun conjunction(): HookBuilderKt.ContainerSyntaxKt<Match> {
        TODO("Write Only")
    }

    override fun disjunction(): HookBuilderKt.ContainerSyntaxKt<Match> {
        TODO("Write Only")
    }

    override fun onMatch(handler: HookBuilderKt.DummyHooker.(Sequence<Reflect>) -> Reflect): Match =
        newImpl(impl.onMatch(HookBuilder.MatchConsumer<Iterable<Reflect>, Reflect> {
            handler(
                DummyHookerImpl, it.asSequence()
            )
        }))

    override fun onMatch(handler: HookBuilderKt.DummyHooker.(Sequence<Reflect>) -> Unit): HookBuilderKt.LazySequenceKt<Match, Reflect, Matcher> =
        newSequence(impl.onMatch(HookBuilder.Consumer<Iterable<Reflect>> { t ->
            DummyHookerImpl.handler(
                t.asSequence()
            )
        }))

    override fun all(init: Matcher.() -> Unit): HookBuilderKt.LazySequenceKt<Match, Reflect, Matcher> =
        newSequence(impl.all {
            newMatcher(it).init()
        })

    override fun first(init: Matcher.() -> Unit): Match = newImpl(impl.first {
        newMatcher(it).init()
    })

    abstract fun newImpl(impl: MatchBase): Match

    abstract fun newMatcher(impl: MatcherBase): Matcher

    abstract fun newSequence(impl: HookBuilder.LazySequence<MatchBase, Reflect, MatcherBase>): HookBuilderKt.LazySequenceKt<Match, Reflect, Matcher>
}

class ClassKtImpl(impl: HookBuilder.Class) :
    ReflectMatchKtImpl<HookBuilderKt.ClassKt, ReflectClass<*>, HookBuilder.Class>(
        impl
    ), HookBuilderKt.ClassKt {
    override val name: HookBuilderKt.StringKt
        get() = StringKtImpl(impl.name)
    override val superClass: HookBuilderKt.ClassKt
        get() = ClassKtImpl(impl.superClass)
    override val interfaces: HookBuilderKt.LazySequenceKt<HookBuilderKt.ClassKt, java.lang.Class<*>, HookBuilderKt.ClassMatcherKt>
        get() = ClassLazySequenceKtImpl(impl.interfaces)
    override val declaredMethods: HookBuilderKt.LazySequenceKt<HookBuilderKt.MethodKt, java.lang.reflect.Method, HookBuilderKt.MethodMatcherKt>
        get() = MethodLazySequenceKtImpl(impl.declaredMethods)
    override val declaredConstructors: HookBuilderKt.LazySequenceKt<HookBuilderKt.ConstructorKt, java.lang.reflect.Constructor<*>, HookBuilderKt.ConstructorMatcherKt>
        get() = ConstructorLazySequenceKtImpl(impl.declaredConstructors)
    override val declaredFields: HookBuilderKt.LazySequenceKt<HookBuilderKt.FieldKt, java.lang.reflect.Field, HookBuilderKt.FieldMatcherKt>
        get() = FieldLazySequenceKtImpl(impl.declaredFields)
    override val arrayType: HookBuilderKt.ClassKt
        get() = ClassKtImpl(impl.arrayType)

    override fun newImpl(impl: HookBuilder.Class): HookBuilderKt.ClassKt = ClassKtImpl(impl)
}

abstract class MemberMatchKtImpl<Base, Reflect, Impl : HookBuilder.MemberMatch<Impl, Reflect>>(
    impl: Impl
) : ReflectMatchKtImpl<Base, Reflect, Impl>(
    impl
), HookBuilderKt.MemberMatchKt<Base, Reflect> where Reflect : Member {
    final override val declaringClass: HookBuilderKt.ClassKt
        get() = ClassKtImpl(impl.declaringClass)
}

class ClassLazySequenceKtImpl(impl: HookBuilder.LazySequence<HookBuilder.Class, ReflectClass<*>, HookBuilder.ClassMatcher>) :
    LazySequenceKtImpl<HookBuilderKt.ClassKt, ReflectClass<*>, HookBuilderKt.ClassMatcherKt, HookBuilder.Class, HookBuilder.ClassMatcher>(
        impl
    ) {
    override fun newImpl(impl: HookBuilder.Class): HookBuilderKt.ClassKt = ClassKtImpl(impl)

    override fun newMatcher(impl: HookBuilder.ClassMatcher): HookBuilderKt.ClassMatcherKt =
        ClassMatcherKtImpl(impl)

    override fun newSequence(impl: HookBuilder.LazySequence<HookBuilder.Class, java.lang.Class<*>, HookBuilder.ClassMatcher>): HookBuilderKt.LazySequenceKt<HookBuilderKt.ClassKt, ReflectClass<*>, HookBuilderKt.ClassMatcherKt> =
        ClassLazySequenceKtImpl(impl)
}

class FieldLazySequenceKtImpl(impl: HookBuilder.LazySequence<HookBuilder.Field, java.lang.reflect.Field, HookBuilder.FieldMatcher>) :
    LazySequenceKtImpl<HookBuilderKt.FieldKt, java.lang.reflect.Field, HookBuilderKt.FieldMatcherKt, HookBuilder.Field, HookBuilder.FieldMatcher>(
        impl
    ) {
    override fun newImpl(impl: HookBuilder.Field): HookBuilderKt.FieldKt = FieldKtImpl(impl)

    override fun newMatcher(impl: HookBuilder.FieldMatcher): HookBuilderKt.FieldMatcherKt =
        FieldMatcherKtImpl(impl)

    override fun newSequence(impl: HookBuilder.LazySequence<HookBuilder.Field, java.lang.reflect.Field, HookBuilder.FieldMatcher>): HookBuilderKt.LazySequenceKt<HookBuilderKt.FieldKt, java.lang.reflect.Field, HookBuilderKt.FieldMatcherKt> =
        FieldLazySequenceKtImpl(impl)
}

class MethodLazySequenceKtImpl(impl: HookBuilder.LazySequence<HookBuilder.Method, java.lang.reflect.Method, HookBuilder.MethodMatcher>) :
    LazySequenceKtImpl<HookBuilderKt.MethodKt, java.lang.reflect.Method, HookBuilderKt.MethodMatcherKt, HookBuilder.Method, HookBuilder.MethodMatcher>(
        impl
    ) {
    override fun newImpl(impl: HookBuilder.Method): HookBuilderKt.MethodKt = MethodKtImpl(impl)

    override fun newMatcher(impl: HookBuilder.MethodMatcher): HookBuilderKt.MethodMatcherKt =
        MethodMatcherKtImpl(impl)

    override fun newSequence(impl: HookBuilder.LazySequence<HookBuilder.Method, java.lang.reflect.Method, HookBuilder.MethodMatcher>): HookBuilderKt.LazySequenceKt<HookBuilderKt.MethodKt, java.lang.reflect.Method, HookBuilderKt.MethodMatcherKt> =
        MethodLazySequenceKtImpl(impl)
}

class ConstructorLazySequenceKtImpl(impl: HookBuilder.LazySequence<HookBuilder.Constructor, java.lang.reflect.Constructor<*>, HookBuilder.ConstructorMatcher>) :
    LazySequenceKtImpl<HookBuilderKt.ConstructorKt, ReflectConstructor<*>, HookBuilderKt.ConstructorMatcherKt, HookBuilder.Constructor, HookBuilder.ConstructorMatcher>(
        impl
    ) {
    override fun newImpl(impl: HookBuilder.Constructor): HookBuilderKt.ConstructorKt =
        ConstructorKtImpl(impl)

    override fun newMatcher(impl: HookBuilder.ConstructorMatcher): HookBuilderKt.ConstructorMatcherKt =
        ConstructorMatcherKtImpl(impl)

    override fun newSequence(impl: HookBuilder.LazySequence<HookBuilder.Constructor, ReflectConstructor<*>, HookBuilder.ConstructorMatcher>): HookBuilderKt.LazySequenceKt<HookBuilderKt.ConstructorKt, java.lang.reflect.Constructor<*>, HookBuilderKt.ConstructorMatcherKt> =
        ConstructorLazySequenceKtImpl(impl)
}

class StringLazySequenceKtImpl(impl: HookBuilder.LazySequence<HookBuilder.String, KtString, HookBuilder.StringMatcher>) :
    LazySequenceKtImpl<HookBuilderKt.StringKt, KtString, HookBuilderKt.StringMatcherKt, HookBuilder.String, HookBuilder.StringMatcher>(
        impl
    ) {
    override fun newImpl(impl: HookBuilder.String): HookBuilderKt.StringKt = StringKtImpl(impl)

    override fun newMatcher(impl: HookBuilder.StringMatcher): HookBuilderKt.StringMatcherKt =
        StringMatcherKtImpl(impl)

    override fun newSequence(impl: HookBuilder.LazySequence<HookBuilder.String, KtString, HookBuilder.StringMatcher>): HookBuilderKt.LazySequenceKt<HookBuilderKt.StringKt, KtString, HookBuilderKt.StringMatcherKt> =
        StringLazySequenceKtImpl(impl)
}

abstract class ExecutableMatchKtImpl<Base, Reflect, Impl : HookBuilder.ExecutableMatch<Impl, Reflect>>(
    impl: Impl
) : MemberMatchKtImpl<Base, Reflect, Impl>(
    impl
), HookBuilderKt.ExecutableMatchKt<Base, Reflect> where Reflect : Member {
    final override val parameterTypes: HookBuilderKt.LazySequenceKt<HookBuilderKt.ClassKt, ReflectClass<*>, HookBuilderKt.ClassMatcherKt>
        get() = ClassLazySequenceKtImpl(impl.parameterTypes)

    @HookBuilderKt.DexAnalysis
    final override val referredStrings: HookBuilderKt.LazySequenceKt<HookBuilderKt.StringKt, KtString, HookBuilderKt.StringMatcherKt>
        get() = StringLazySequenceKtImpl(impl.referredStrings)

    @HookBuilderKt.DexAnalysis
    final override val assignedFields: HookBuilderKt.LazySequenceKt<HookBuilderKt.FieldKt, java.lang.reflect.Field, HookBuilderKt.FieldMatcherKt>
        get() = FieldLazySequenceKtImpl(impl.assignedFields)

    @HookBuilderKt.DexAnalysis
    final override val accessedFields: HookBuilderKt.LazySequenceKt<HookBuilderKt.FieldKt, java.lang.reflect.Field, HookBuilderKt.FieldMatcherKt>
        get() = FieldLazySequenceKtImpl(impl.accessedFields)

    @HookBuilderKt.DexAnalysis
    final override val invokedMethods: HookBuilderKt.LazySequenceKt<HookBuilderKt.MethodKt, java.lang.reflect.Method, HookBuilderKt.MethodMatcherKt>
        get() = MethodLazySequenceKtImpl(impl.invokedMethods)

    @HookBuilderKt.DexAnalysis
    final override val invokedConstructors: HookBuilderKt.LazySequenceKt<HookBuilderKt.ConstructorKt, java.lang.reflect.Constructor<*>, HookBuilderKt.ConstructorMatcherKt>
        get() = ConstructorLazySequenceKtImpl(impl.invokedConstructors)
}

class MethodKtImpl(impl: HookBuilder.Method) :
    ExecutableMatchKtImpl<HookBuilderKt.MethodKt, ReflectMethod, HookBuilder.Method>(
        impl
    ), HookBuilderKt.MethodKt {
    override val name: HookBuilderKt.StringKt
        get() = StringKtImpl(impl.name)
    override val returnType: HookBuilderKt.ClassKt
        get() = ClassKtImpl(impl.returnType)

    override fun newImpl(impl: HookBuilder.Method): HookBuilderKt.MethodKt = MethodKtImpl(impl)
}

class ConstructorKtImpl(impl: HookBuilder.Constructor) :
    ExecutableMatchKtImpl<HookBuilderKt.ConstructorKt, ReflectConstructor<*>, HookBuilder.Constructor>(
        impl
    ), HookBuilderKt.ConstructorKt {
    override fun newImpl(impl: HookBuilder.Constructor): HookBuilderKt.ConstructorKt =
        ConstructorKtImpl(impl)
}

class FieldKtImpl(impl: HookBuilder.Field) :
    MemberMatchKtImpl<HookBuilderKt.FieldKt, ReflectField, HookBuilder.Field>(
        impl
    ), HookBuilderKt.FieldKt {
    override val name: HookBuilderKt.StringKt
        get() = StringKtImpl(impl.name)
    override val type: HookBuilderKt.ClassKt
        get() = ClassKtImpl(impl.type)

    override fun newImpl(impl: HookBuilder.Field): HookBuilderKt.FieldKt = FieldKtImpl(impl)
}

class StringKtImpl(impl: HookBuilder.String) :
    BaseMatchKtImpl<HookBuilderKt.StringKt, KtString, HookBuilder.String>(impl),
    HookBuilderKt.StringKt

internal class HookBuilderKtImpl(
    ctx: XposedInterface,
    classLoader: BaseDexClassLoader,
    sourcePath: KtString
) : HookBuilderKt {
    private val builder = HookBuilderImpl(ctx, classLoader, sourcePath)

    override var lastMatchResult: HookBuilderKt.MatchResultKt
        get() = TODO("Write Only")
        set(value) {
            builder.setLastMatchResult((value as MatchResultKtImpl).impl)
        }

    override var exceptionHandler: (Throwable) -> Boolean
        get() = TODO("Write Only")
        set(value) {
            builder.setExceptionHandler(value)
        }

    override fun methods(init: HookBuilderKt.MethodMatcherKt.() -> Unit): HookBuilderKt.LazySequenceKt<HookBuilderKt.MethodKt, ReflectMethod, HookBuilderKt.MethodMatcherKt> =
        MethodLazySequenceKtImpl(builder.methods {
            MethodMatcherKtImpl(it).init()
        })

    override fun firstMethod(init: HookBuilderKt.MethodMatcherKt.() -> Unit): HookBuilderKt.MethodKt =
        MethodKtImpl(builder.firstMethod {
            MethodMatcherKtImpl(it).init()
        })

    override fun classes(init: HookBuilderKt.ClassMatcherKt.() -> Unit): HookBuilderKt.LazySequenceKt<HookBuilderKt.ClassKt, ReflectClass<*>, HookBuilderKt.ClassMatcherKt> =
        ClassLazySequenceKtImpl(builder.classes {
            ClassMatcherKtImpl(it).init()
        })

    override fun firstClass(init: HookBuilderKt.ClassMatcherKt.() -> Unit): HookBuilderKt.ClassKt =
        ClassKtImpl(builder.firstClass {
            ClassMatcherKtImpl(it).init()
        })

    override fun fields(init: HookBuilderKt.FieldMatcherKt.() -> Unit): HookBuilderKt.LazySequenceKt<HookBuilderKt.FieldKt, ReflectField, HookBuilderKt.FieldMatcherKt> =
        FieldLazySequenceKtImpl(builder.fields {
            FieldMatcherKtImpl(it).init()
        })

    override fun firstField(init: HookBuilderKt.FieldMatcherKt.() -> Unit): HookBuilderKt.FieldKt =
        FieldKtImpl(builder.firstField {
            FieldMatcherKtImpl(it).init()
        })

    override fun constructors(init: HookBuilderKt.ConstructorMatcherKt.() -> Unit): HookBuilderKt.LazySequenceKt<HookBuilderKt.ConstructorKt, ReflectConstructor<*>, HookBuilderKt.ConstructorMatcherKt> =
        ConstructorLazySequenceKtImpl(builder.constructors {
            ConstructorMatcherKtImpl(it).init()
        })

    override fun firstConstructor(init: HookBuilderKt.ConstructorMatcherKt.() -> Unit): HookBuilderKt.ConstructorKt =
        ConstructorKtImpl(builder.firstConstructor {
            ConstructorMatcherKtImpl(it).init()
        })

    override fun string(init: HookBuilderKt.StringMatcherKt.() -> Unit): HookBuilderKt.StringKt =
        StringKtImpl(builder.string {
            StringMatcherKtImpl(it).init()
        })

    override val KtString.exact: HookBuilderKt.StringKt
        get() = StringKtImpl(builder.exact(this))
    override val ReflectClass<*>.exact: HookBuilderKt.ClassKt
        get() = ClassKtImpl(builder.exact(this))
    override val ReflectMethod.exact: HookBuilderKt.MethodKt
        get() = MethodKtImpl(builder.exact(this))
    override val ReflectConstructor<*>.exact: HookBuilderKt.ConstructorKt
        get() = ConstructorKtImpl(builder.exact(this))
    override val ReflectField.exact: HookBuilderKt.FieldKt
        get() = FieldKtImpl(builder.exact(this))
    override val KtString.prefix: HookBuilderKt.StringKt
        get() = StringKtImpl(builder.prefix(this))
    override val KtString.exactClass: HookBuilderKt.ClassKt
        get() = ClassKtImpl(builder.exactClass(this))

    class MatchResultKtImpl(val impl: HookBuilder.MatchResult) : HookBuilderKt.MatchResultKt {
        override val matchedClasses: Map<KtString, ReflectClass<*>>
            get() = impl.matchedClasses
        override val matchedFields: Map<KtString, ReflectField>
            get() = impl.matchedFields
        override val matchedMethods: Map<KtString, ReflectMethod>
            get() = impl.matchedMethods
        override val matchedConstructors: Map<KtString, ReflectConstructor<*>>
            get() = impl.matchedConstructors
    }

    fun build() = MatchResultKtImpl(builder.build())
}
