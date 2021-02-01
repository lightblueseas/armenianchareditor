package io.github.astrapi69.chareditor.viewmodel;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharacterInfo {
    String unicode;
    String latin;
    String htmlEntity;
    String representation;
    String description;
}
