package tech.takenoko.easyandroidapp.model.ormadb.dto;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;

import io.reactivex.annotations.Nullable;
import lombok.Data;

/**
 * Created by takenoko on 2018/04/29.
 */
@Data
@Table
public class LogDto {

    @PrimaryKey(autoincrement = true)
    private long id;

    @Column(indexed = true)
    private String log1;

    @Column
    @Nullable
    private String log2;
}
