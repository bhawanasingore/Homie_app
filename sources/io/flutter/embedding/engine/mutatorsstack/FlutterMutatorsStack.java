package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class FlutterMutatorsStack {
    private List<Path> finalClippingPaths = new ArrayList();
    private Matrix finalMatrix = new Matrix();
    private List<FlutterMutator> mutators = new ArrayList();

    public enum FlutterMutatorType {
        CLIP_RECT,
        CLIP_RRECT,
        CLIP_PATH,
        TRANSFORM,
        OPACITY
    }

    public class FlutterMutator {
        private Matrix matrix;
        private Path path;
        private Rect rect;
        private FlutterMutatorType type;

        public FlutterMutator(Rect rect2) {
            this.type = FlutterMutatorType.CLIP_RECT;
            this.rect = rect2;
        }

        public FlutterMutator(Path path2) {
            this.type = FlutterMutatorType.CLIP_PATH;
            this.path = path2;
        }

        public FlutterMutator(Matrix matrix2) {
            this.type = FlutterMutatorType.TRANSFORM;
            this.matrix = matrix2;
        }

        public FlutterMutatorType getType() {
            return this.type;
        }

        public Rect getRect() {
            return this.rect;
        }

        public Path getPath() {
            return this.path;
        }

        public Matrix getMatrix() {
            return this.matrix;
        }
    }

    public void pushTransform(float[] values) {
        Matrix matrix = new Matrix();
        matrix.setValues(values);
        FlutterMutator mutator = new FlutterMutator(matrix);
        this.mutators.add(mutator);
        this.finalMatrix.preConcat(mutator.getMatrix());
    }

    public void pushClipRect(int left, int top, int right, int bottom) {
        Rect rect = new Rect(left, top, right, bottom);
        this.mutators.add(new FlutterMutator(rect));
        Path path = new Path();
        path.addRect(new RectF(rect), Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public List<FlutterMutator> getMutators() {
        return this.mutators;
    }

    public List<Path> getFinalClippingPaths() {
        return this.finalClippingPaths;
    }

    public Matrix getFinalMatrix() {
        return this.finalMatrix;
    }
}
