//
//  HorizontalSlideView.swift
//  iOS
//
//  Created by Financial CB on 2023/08/23.
//

import SwiftUI

struct HorizontalScrollView: View {
    var body: some View {
        ScrollView(.horizontal, showsIndicators: false) {
            HStack(spacing: 20) {
                ForEach(scrollData) { data in
                    ZStack(alignment: .bottom) {
                        AsyncImage(
                            url: URL(string: data.image),
                            content: { image in
                                image
                                    .resizable()
                                    .aspectRatio(contentMode: .fill)
                            }, placeholder: {
                                Color.white
                            })
                        .frame(maxWidth: 315, maxHeight: 420)
                        .clipShape(RoundedRectangle(cornerRadius: 30))
                        Text(data.title)
                            .foregroundStyle(.white)
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .padding(.horizontal, 20)
                            .padding(.vertical, 70)
                            .bold()
                        Text(data.text)
                            .foregroundStyle(.white)
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .padding(.horizontal, 20)
                            .padding(.vertical, 40)
                            .bold()
                    }
                }
            }
        }
    }
}

struct HorizontalSlideView_Previews: PreviewProvider {
    static var previews: some View {
        HorizontalScrollView()
    }
}
