package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {33, 39, 46, 52, 55}, m = "invokeSuspend", n = {"$this$iterator", "gap", "buffer", "skip", "e", "$this$iterator", "gap", "buffer", "skip", "$this$iterator", "gap", "buffer", "e", "$this$iterator", "gap", "buffer", "$this$iterator", "gap", "buffer"}, s = {"L$0", "I$0", "L$1", "I$1", "L$2", "L$0", "I$0", "L$1", "I$1", "L$0", "I$0", "L$1", "L$2", "L$0", "I$0", "L$1", "L$0", "I$0", "L$1"})
/* compiled from: SlidingWindow.kt */
final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Iterator $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private SequenceScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator it, boolean z, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.$step = i;
        this.$size = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$step, this.$size, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        SequenceScope sequenceScope = (SequenceScope) obj;
        slidingWindowKt$windowedIterator$1.p$ = (SequenceScope) obj;
        return slidingWindowKt$windowedIterator$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SlidingWindowKt$windowedIterator$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: kotlin.sequences.SequenceScope} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: kotlin.collections.RingBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: kotlin.sequences.SequenceScope} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: kotlin.collections.RingBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: kotlin.sequences.SequenceScope} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: kotlin.sequences.SequenceScope} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x013e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0118 A[SYNTHETIC] */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x00b5
            r8 = 0
            r9 = 0
            if (r2 == r7) goto L_0x0094
            if (r2 == r6) goto L_0x0077
            if (r2 == r5) goto L_0x0056
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            r1 = r9
            r2 = r9
            r3 = r8
            java.lang.Object r4 = r0.L$1
            r2 = r4
            kotlin.collections.RingBuffer r2 = (kotlin.collections.RingBuffer) r2
            int r3 = r0.I$0
            java.lang.Object r4 = r0.L$0
            r1 = r4
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            kotlin.ResultKt.throwOnFailure(r17)
            r10 = r0
            r6 = r1
            r1 = r17
            goto L_0x01e0
        L_0x0033:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003b:
            r2 = r9
            r5 = r9
            r6 = r8
            java.lang.Object r8 = r0.L$1
            r5 = r8
            kotlin.collections.RingBuffer r5 = (kotlin.collections.RingBuffer) r5
            int r6 = r0.I$0
            java.lang.Object r8 = r0.L$0
            r2 = r8
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            kotlin.ResultKt.throwOnFailure(r17)
            r10 = r0
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r1
            r1 = r17
            goto L_0x01bf
        L_0x0056:
            r2 = r9
            r6 = r9
            r9 = r8
            java.lang.Object r10 = r0.L$3
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r8 = r0.L$2
            java.lang.Object r11 = r0.L$1
            r6 = r11
            kotlin.collections.RingBuffer r6 = (kotlin.collections.RingBuffer) r6
            int r9 = r0.I$0
            java.lang.Object r11 = r0.L$0
            r2 = r11
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            kotlin.ResultKt.throwOnFailure(r17)
            r11 = r0
            r12 = r8
            r8 = r6
            r6 = r2
            r2 = r1
            r1 = r17
            goto L_0x018b
        L_0x0077:
            r1 = r9
            r2 = r9
            r3 = r8
            r4 = r8
            int r4 = r0.I$1
            java.lang.Object r5 = r0.L$1
            r2 = r5
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r3 = r0.I$0
            java.lang.Object r5 = r0.L$0
            r1 = r5
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            kotlin.ResultKt.throwOnFailure(r17)
            r10 = r0
            r5 = r4
            r4 = r2
            r2 = r1
            r1 = r17
            goto L_0x0140
        L_0x0094:
            r2 = r9
            r3 = r9
            r4 = r9
            r5 = r8
            java.lang.Object r9 = r0.L$3
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r3 = r0.L$2
            int r8 = r0.I$1
            java.lang.Object r10 = r0.L$1
            r4 = r10
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            int r5 = r0.I$0
            java.lang.Object r10 = r0.L$0
            r2 = r10
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            kotlin.ResultKt.throwOnFailure(r17)
            r10 = r0
            r11 = r3
            r3 = r1
            r1 = r17
            goto L_0x0104
        L_0x00b5:
            kotlin.ResultKt.throwOnFailure(r17)
            kotlin.sequences.SequenceScope r2 = r0.p$
            int r8 = r0.$step
            int r9 = r0.$size
            int r8 = r8 - r9
            if (r8 < 0) goto L_0x0142
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r0.$size
            r3.<init>(r4)
            r4 = 0
            java.util.Iterator r5 = r0.$iterator
            r10 = r0
            r9 = r5
            r5 = r4
            r4 = r3
            r3 = r1
            r1 = r17
        L_0x00d2:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0118
            java.lang.Object r11 = r9.next()
            if (r5 <= 0) goto L_0x00e1
            int r5 = r5 + -1
            goto L_0x0117
        L_0x00e1:
            r4.add(r11)
            int r12 = r4.size()
            int r13 = r10.$size
            if (r12 != r13) goto L_0x0117
            r10.L$0 = r2
            r10.I$0 = r8
            r10.L$1 = r4
            r10.I$1 = r5
            r10.L$2 = r11
            r10.L$3 = r9
            r10.label = r7
            java.lang.Object r12 = r2.yield(r4, r10)
            if (r12 != r3) goto L_0x0101
            return r3
        L_0x0101:
            r15 = r8
            r8 = r5
            r5 = r15
        L_0x0104:
            boolean r12 = r10.$reuseBuffer
            if (r12 == 0) goto L_0x010c
            r4.clear()
            goto L_0x0114
        L_0x010c:
            java.util.ArrayList r12 = new java.util.ArrayList
            int r13 = r10.$size
            r12.<init>(r13)
            r4 = r12
        L_0x0114:
            r8 = r5
            r15 = r8
            r5 = r15
        L_0x0117:
            goto L_0x00d2
        L_0x0118:
            r9 = r4
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            r7 = r7 ^ r9
            if (r7 == 0) goto L_0x01e6
            boolean r7 = r10.$partialWindows
            if (r7 != 0) goto L_0x012e
            int r7 = r4.size()
            int r9 = r10.$size
            if (r7 != r9) goto L_0x01e6
        L_0x012e:
            r10.L$0 = r2
            r10.I$0 = r8
            r10.L$1 = r4
            r10.I$1 = r5
            r10.label = r6
            java.lang.Object r6 = r2.yield(r4, r10)
            if (r6 != r3) goto L_0x013f
            return r3
        L_0x013f:
            r3 = r8
        L_0x0140:
            goto L_0x01e6
        L_0x0142:
            kotlin.collections.RingBuffer r6 = new kotlin.collections.RingBuffer
            int r9 = r0.$size
            r6.<init>(r9)
            java.util.Iterator r9 = r0.$iterator
            r11 = r0
            r10 = r9
            r9 = r8
            r8 = r6
            r6 = r2
            r2 = r1
            r1 = r17
        L_0x0153:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x0191
            java.lang.Object r12 = r10.next()
            r8.add(r12)
            boolean r13 = r8.isFull()
            if (r13 == 0) goto L_0x0190
            boolean r13 = r11.$reuseBuffer
            if (r13 == 0) goto L_0x016e
            r13 = r8
            java.util.List r13 = (java.util.List) r13
            goto L_0x0178
        L_0x016e:
            java.util.ArrayList r13 = new java.util.ArrayList
            r14 = r8
            java.util.Collection r14 = (java.util.Collection) r14
            r13.<init>(r14)
            java.util.List r13 = (java.util.List) r13
        L_0x0178:
            r11.L$0 = r6
            r11.I$0 = r9
            r11.L$1 = r8
            r11.L$2 = r12
            r11.L$3 = r10
            r11.label = r5
            java.lang.Object r13 = r6.yield(r13, r11)
            if (r13 != r2) goto L_0x018b
            return r2
        L_0x018b:
            int r13 = r11.$step
            r8.removeFirst(r13)
        L_0x0190:
            goto L_0x0153
        L_0x0191:
            boolean r5 = r11.$partialWindows
            if (r5 == 0) goto L_0x01e4
            r10 = r11
        L_0x0196:
            int r5 = r8.size()
            int r11 = r10.$step
            if (r5 <= r11) goto L_0x01c5
            boolean r5 = r10.$reuseBuffer
            if (r5 == 0) goto L_0x01a6
            r5 = r8
            java.util.List r5 = (java.util.List) r5
            goto L_0x01b0
        L_0x01a6:
            java.util.ArrayList r5 = new java.util.ArrayList
            r11 = r8
            java.util.Collection r11 = (java.util.Collection) r11
            r5.<init>(r11)
            java.util.List r5 = (java.util.List) r5
        L_0x01b0:
            r10.L$0 = r6
            r10.I$0 = r9
            r10.L$1 = r8
            r10.label = r4
            java.lang.Object r5 = r6.yield(r5, r10)
            if (r5 != r2) goto L_0x01bf
            return r2
        L_0x01bf:
            int r5 = r10.$step
            r8.removeFirst(r5)
            goto L_0x0196
        L_0x01c5:
            r4 = r8
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r7
            if (r4 == 0) goto L_0x01e2
            r10.L$0 = r6
            r10.I$0 = r9
            r10.L$1 = r8
            r10.label = r3
            java.lang.Object r3 = r6.yield(r8, r10)
            if (r3 != r2) goto L_0x01de
            return r2
        L_0x01de:
            r2 = r8
            r3 = r9
        L_0x01e0:
            r2 = r6
            goto L_0x01e6
        L_0x01e2:
            r2 = r6
            goto L_0x01e6
        L_0x01e4:
            r2 = r6
            r10 = r11
        L_0x01e6:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
