package me.spruce.game.setting;

public class Setting<T> {

    public String name, description;
    private T value;
    private T min, max, inc;

    public Setting(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public Setting(String name, String description, T value) {
        this(name, value);
        this.description = description;
    }

    public Setting(String name, T value, T min, T max, T inc) {
        this(name, value);
        this.min = min;
        this.max = max;
        this.inc = inc;
    }

    public Setting(String name, String description, T value, T min, T max, T inc) {
        this(name, description, value);
        this.min = min;
        this.max = max;
        this.inc = inc;
    }

    public T getValue() {
        return value;
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }

    public T getInc() {
        return inc;
    }

    @SuppressWarnings("unchecked")
    public <U> void setValue(U value) {
        try {
            if (this.value instanceof Enum<?>) {
//            this.setValue((T) getEnumReal((String) value));
                this.value = (T) getEnumReal(((Enum<?>) value).name());
            } else if (this.value instanceof Number) {
//                final T foo = this.clamp((T) value, min, max);
//                this.value = (T) (Number) (Math.round(((Number) foo).floatValue() * ((Number) inc).floatValue()) / ((Number) inc).floatValue());
                this.value = (T) value;
            } else {
                this.value = (T) value;
            }
        } catch (Exception e) {
            System.out.println("Lmao it die and error!");
            e.printStackTrace();
        }
    }

    private T clamp(T value, T min, T max) {
        float floatValue = Float.parseFloat(value.toString());
        float floatMin = Float.parseFloat(min.toString());
        float floatMax = Float.parseFloat(max.toString());

        return ((Comparable<? super Float>) floatValue).compareTo(floatMin) < 0 ? min
                : (((Comparable<? super Float>) floatValue).compareTo(floatMax) > 0 ? max
                : value);
    }

    public String getNextEnumValue(boolean p_Reverse) {
        Enum<?> currEnum = (Enum<?>) this.getValue();

        int i = 0;
        for (; i < this.value.getClass().getEnumConstants().length; i++) {
            Enum<?> e = (Enum<?>) this.value.getClass().getEnumConstants()[i];
            if (e.name().equalsIgnoreCase(currEnum.name())) {
                break;
            }
        }

        return this.value.getClass()
                .getEnumConstants()[(p_Reverse ? (i != 0 ? i - 1 : value.getClass().getEnumConstants().length - 1)
                : i + 1) % value.getClass().getEnumConstants().length].toString();
    }

    public int getEnumIndex(String input) {
        for (int i = 0; i < this.value.getClass().getEnumConstants().length; i++) {
            Enum<?> e = (Enum<?>) this.value.getClass().getEnumConstants()[i];
            if (e.name().equalsIgnoreCase(input)) {
                return i;
            }
        }
        return -1;
    }

    public Enum<?> getEnumReal(String input) {
        for (int i = 0; i < this.value.getClass().getEnumConstants().length; i++) {
            Enum<?> e = (Enum<?>) this.value.getClass().getEnumConstants()[i];
            if (e.name().equalsIgnoreCase(input)) {
                return e;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public void setEnumValue(String value) {
        for (Enum<?> e : ((Enum<?>) this.value).getClass().getEnumConstants()) {
            if (e.name().equalsIgnoreCase(value)) {
                setValue((T) e);
                break;
            }
        }
    }

}
